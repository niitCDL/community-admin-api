package com.soft2242.one.system.controller;

import com.soft2242.one.system.service.SysLoginLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/log/login")
@Tag(name = "登录日志")
@AllArgsConstructor
public class SysLoginLogController {

    private final SysLoginLogService sysLoginLogService;
    @GetMapping("export")
    @Operation(summary = "导出登录日志")
    public void export() {
        sysLoginLogService.export();
    }

}
