package com.soft2242.one.system.controller;

import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.system.convert.SysUserInfoConvert;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysUserService sysUserService;

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SysUserInfoVO> get(@PathVariable("id") Long id) {
        SysUserInfoEntity entity = sysUserService.getUserInfoByAdminId(id);

        SysUserInfoVO vo = SysUserInfoConvert.INSTANCE.convert(entity);

        return Result.ok(vo);
    }
}
