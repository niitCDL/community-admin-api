package com.soft2242.one.system.controller;

import cn.hutool.core.util.StrUtil;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.system.convert.SysUserInfoConvert;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserInfoVO;
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
}
