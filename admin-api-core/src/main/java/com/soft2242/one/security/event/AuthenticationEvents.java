package com.soft2242.one.security.event;

import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.service.SysLoginLogService;
import com.soft2242.one.system.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * 认证事件处理
 *
 * @author mqxu
 */
@Component
@AllArgsConstructor
public class AuthenticationEvents {

    private SysLoginLogService sysLoginLogService;

    private SysUserService sysUserService;

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) throws Exception{
        // 用户信息
        UserDetail user = (UserDetail) event.getAuthentication().getPrincipal();

        //记录系统登录日志
        sysLoginLogService.record();

        //记录用户最后登录时间
        sysUserService.recordLastLoginTime(DateUtils.format(DateUtils.CURRENT_DATE,DateUtils.DATE_TIME_PATTERN),user.getId());

        System.out.println("登录成功");
    }


    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event) {
        System.out.println("登录失败");
    }

}