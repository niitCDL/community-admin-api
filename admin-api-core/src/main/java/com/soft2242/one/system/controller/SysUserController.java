package com.soft2242.one.system.controller;

import cn.hutool.core.util.StrUtil;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.base.security.user.SecurityUser;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.convert.SysUserConvert;
import com.soft2242.one.system.convert.SysUserInfoConvert;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysUserService sysUserService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SysUserInfoVO> get(@PathVariable("id") Long id) {
        SysUserInfoEntity entity = sysUserService.getUserInfoByAdminId(id);

        SysUserInfoVO vo = SysUserInfoConvert.INSTANCE.convert(entity);

        return Result.ok(vo);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysUserInfoVO vo) {
        // 新增密码不能为空
        if (StrUtil.isBlank(vo.getPassword())) {
            Result.error("密码不能为空");
        }

        // 密码加密
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));

        // 保存
        sysUserService.save(vo);

        return Result.ok();
    }

    @PutMapping("info")
    @Operation(summary = "登录用户")
    public Result<SysUserVO> info() {
        UserDetail userDetail = SecurityUser.getUser();
        System.out.println(userDetail);
        SysUserVO user = SysUserInfoConvert.INSTANCE.convert(userDetail);
        return Result.ok(user);
    }

    @PutMapping
    @Operation(summary = "修改用户状态")
    public Result changeAccountStatus(Long id,Integer accountStatus) {
        sysUserService.changeAccountStatus(id,accountStatus);
        return Result.ok();
    }
}
