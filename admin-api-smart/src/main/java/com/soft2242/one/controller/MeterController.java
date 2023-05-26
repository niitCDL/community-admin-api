package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.MeterConvert;
import com.soft2242.one.entity.MeterEntity;
import com.soft2242.one.query.MeterQuery;
import com.soft2242.one.service.MeterService;
import com.soft2242.one.vo.MeterVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 仪表表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@RestController
@RequestMapping("smart/meter")
@Tag(name="仪表表")
@AllArgsConstructor
public class MeterController {
    private final MeterService meterService;

    @GetMapping("page")
    @Operation(summary = "分页")
    // @PreAuthorize("hasAuthority('sys:meter:page')")
    public Result<PageResult<MeterVO>> page(@ParameterObject @Valid MeterQuery query){
        PageResult<MeterVO> page = meterService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    // @PreAuthorize("hasAuthority('sys:meter:info')")
    public Result<MeterVO> get(@PathVariable("id") Long id){
        MeterEntity entity = meterService.getById(id);

        return Result.ok(MeterConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    // @PreAuthorize("hasAuthority('sys:meter:save')")
    public Result<String> save(@RequestBody MeterVO vo){
        meterService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    // @PreAuthorize("hasAuthority('sys:meter:update')")
    public Result<String> update(@RequestBody @Valid MeterVO vo){
        meterService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    // @PreAuthorize("hasAuthority('sys:meter:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        meterService.delete(idList);

        return Result.ok();
    }
}