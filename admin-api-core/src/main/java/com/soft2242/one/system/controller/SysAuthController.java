package com.soft2242.one.system.controller;

import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.system.service.SysAuthService;
import com.soft2242.one.system.service.SysCaptchaService;
import com.soft2242.one.system.vo.SysAccountLoginVO;
import com.soft2242.one.system.vo.SysCaptchaVO;
import com.soft2242.one.system.vo.SysTokenVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 认证管理
 *
 * @author moqi
 */
@RestController
@RequestMapping("sys/auth")
@Tag(name = "认证管理")
@AllArgsConstructor
public class SysAuthController {
    private final SysCaptchaService sysCaptchaService;
    private final SysAuthService sysAuthService;

    @GetMapping("captcha")
    @Operation(summary = "验证码")
    public Result<SysCaptchaVO> captcha() {
        SysCaptchaVO captchaVO = sysCaptchaService.generate();

        return Result.ok(captchaVO);
    }

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<SysTokenVO> login(@RequestBody SysAccountLoginVO login) {
        SysTokenVO token = sysAuthService.loginByAccount(login);
        return Result.ok(token);
    }
}
