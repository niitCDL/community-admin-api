package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.MonitorConvert;
import com.soft2242.one.entity.MonitorEntity;
import com.soft2242.one.query.MonitorQuery;
import com.soft2242.one.service.MonitorService;
import com.soft2242.one.vo.MonitorVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 监控表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@RestController
@RequestMapping("smart/monitor")
@Tag(name="监控表")
@AllArgsConstructor
public class MonitorController {
    private final MonitorService monitorService;

    @GetMapping("page")
    @Operation(summary = "分页")
    // @PreAuthorize("hasAuthority('sys:monitor:page')")
    public Result<PageResult<MonitorVO>> page(@ParameterObject @Valid MonitorQuery query){
        PageResult<MonitorVO> page = monitorService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    // @PreAuthorize("hasAuthority('sys:monitor:info')")
    public Result<MonitorVO> get(@PathVariable("id") Long id){
        MonitorEntity entity = monitorService.getById(id);

        return Result.ok(MonitorConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    // @PreAuthorize("hasAuthority('sys:monitor:save')")
    public Result<String> save(@RequestBody MonitorVO vo){
        monitorService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    // @PreAuthorize("hasAuthority('sys:monitor:update')")
    public Result<String> update(@RequestBody @Valid MonitorVO vo){
        monitorService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    // @PreAuthorize("hasAuthority('sys:monitor:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        monitorService.delete(idList);

        return Result.ok();
    }
}