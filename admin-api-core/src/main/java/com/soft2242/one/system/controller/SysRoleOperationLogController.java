package com.soft2242.one.system.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.soft2242.one.system.convert.SysRoleOperationLogConvert;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.service.SysRoleOperationLogService;
import com.soft2242.one.system.query.SysRoleOperationLogQuery;
import com.soft2242.one.system.vo.SysRoleOperationLogVO;
import org.apache.ibatis.annotations.Param;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 角色操作记录表
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("sys/role/log")
@Tag(name="角色操作日志管理")
@AllArgsConstructor
public class SysRoleOperationLogController {
    private final SysRoleOperationLogService sysRoleOperationLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:log:page')")
    public Result<PageResult<SysRoleOperationLogVO>> page(@ParameterObject @Valid SysRoleOperationLogQuery query){
        PageResult<SysRoleOperationLogVO> page = sysRoleOperationLogService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:log:info')")
    public Result<SysRoleOperationLogVO> get(@PathVariable("id") Long id){
        SysRoleOperationLogEntity entity = sysRoleOperationLogService.getById(id);

        return Result.ok(SysRoleOperationLogConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:log:save')")
    public Result<String> save(@RequestBody SysRoleOperationLogVO vo){
        sysRoleOperationLogService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:log:update')")
    public Result<String> update(@RequestBody @Valid SysRoleOperationLogVO vo){
        sysRoleOperationLogService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:log:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysRoleOperationLogService.delete(idList);

        return Result.ok();
    }

    @GetMapping("export")
    @Operation(summary = "导出")
    public void export(String toPath){
        sysRoleOperationLogService.export(toPath);
    }
}