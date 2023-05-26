package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.MonitorTypeConvert;
import com.soft2242.one.entity.MonitorTypeEntity;
import com.soft2242.one.query.MonitorTypeQuery;
import com.soft2242.one.service.MonitorTypeService;
import com.soft2242.one.vo.MonitorTypeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 监控分组
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@RestController
@RequestMapping("smart/monitorType")
@Tag(name="监控分组")
@AllArgsConstructor
public class MonitorTypeController {
    private final MonitorTypeService monitorTypeService;

    @GetMapping("page")
    @Operation(summary = "分页")
    // @PreAuthorize("hasAuthority('sys:monitorType:page')")
    public Result<PageResult<MonitorTypeVO>> page(@ParameterObject @Valid MonitorTypeQuery query){
        PageResult<MonitorTypeVO> page = monitorTypeService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    // @PreAuthorize("hasAuthority('sys:monitorType:info')")
    public Result<MonitorTypeVO> get(@PathVariable("id") Long id){
        MonitorTypeEntity entity = monitorTypeService.getById(id);

        return Result.ok(MonitorTypeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    // @PreAuthorize("hasAuthority('sys:monitorType:save')")
    public Result<String> save(@RequestBody MonitorTypeVO vo){
        monitorTypeService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    // @PreAuthorize("hasAuthority('sys:monitorType:update')")
    public Result<String> update(@RequestBody @Valid MonitorTypeVO vo){
        monitorTypeService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    // @PreAuthorize("hasAuthority('sys:monitorType:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        monitorTypeService.delete(idList);

        return Result.ok();
    }

    @GetMapping("list")
    @Operation(summary = "全部列表")
    public Result<List<MonitorTypeEntity>> list() {
        return Result.ok(monitorTypeService.list());
    }
}