package com.soft2242.one.system.service.impl;


import cn.hutool.core.util.RandomUtil;
import com.soft2242.one.api.SmsApi;
import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.base.security.mobile.MobileAuthenticationToken;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.base.security.utils.TokenUtils;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.enums.UserOnlineEnum;
import com.soft2242.one.system.service.SysAuthService;
import com.soft2242.one.system.service.SysCaptchaService;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysAccountLoginVO;
import com.soft2242.one.system.vo.SysMobileLoginVO;
import com.soft2242.one.system.vo.SysTokenVO;
import com.soft2242.one.system.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * 权限认证服务
 *
 * @author ao&dl
 */
@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService {
    private final SysCaptchaService sysCaptchaService;
    private final SysUserService sysUserService;
    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;

    private final SmsApi smsApi;

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {
        // 验证码效验
//        boolean flag = sysCaptchaService.validate(login.getKey(), login.getCaptcha());
//        if (!flag) {
//            // 保存登录日志
//            sysLogLoginService.save(login.getUsername(), Constant.FAIL, LoginOperationEnum.CAPTCHA_FAIL.getValue());
//
//            throw new ServerException("验证码错误");
//        }

        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();


        SysUserInfoEntity userInfo = sysUserService.getUserInfoByAdminId(user.getId());

        user.setRealName(userInfo.getRealName());
        user.setAvatar(userInfo.getAvatar());
        user.setEmail(userInfo.getEmail());
        user.setGender(userInfo.getGender());

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 将登录成功的用户的token存放到数据库中 并记录在线状态
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(user.getId());
        sysUserEntity.setToken(accessToken);
        sysUserEntity.setOnlineStatus(UserOnlineEnum.ONLINE.getValue());
        sysUserService.update(sysUserEntity);

        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // 用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        SysUserEntity entity = new SysUserEntity();
        entity.setId(user.getId());
        entity.setOnlineStatus(UserOnlineEnum.OFFLINE.getValue());
        entity.setToken("");
        // 删除用户信息
        tokenStoreCache.deleteUser(accessToken);

        // 清除admin表中的token
        // 修改在线状态
        sysUserService.update(entity);
    }

    @Override
    public SysTokenVO loginByMobile(SysMobileLoginVO login) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new MobileAuthenticationToken(login.getMobile(), login.getCode()));
        } catch (BadCredentialsException e) {
            throw new ServerException("手机号或验证码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public boolean sendCode(String mobile) {
        // 生成6位验证码
        String code = RandomUtil.randomNumbers(6);

        SysUserVO user = sysUserService.getByMobile(mobile);
        if (user == null) {
            throw new ServerException("手机号未注册");
        }

        // 发送短信
        return smsApi.sendCode(mobile, "code", code);
    }

}
