package com.soft2242.one.system.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.system.query.SysLoginLogQuery;
import com.soft2242.one.system.query.SysRoleQuery;
import com.soft2242.one.system.service.SysLoginLogService;
import com.soft2242.one.system.vo.SysLoginLogExcelVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<SysLoginLogExcelVO>> page(@ParameterObject @Valid SysLoginLogQuery query){
        PageResult<SysLoginLogExcelVO> page = sysLoginLogService.page(query);
        return Result.ok(page);
    }

}
