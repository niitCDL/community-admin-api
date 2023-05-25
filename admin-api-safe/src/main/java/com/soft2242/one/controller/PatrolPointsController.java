package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolPointsConvert;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.service.PatrolPointsService;
import com.soft2242.one.vo.PatrolPointsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 巡更点表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("sys/point")
@Tag(name="巡更点表")
@AllArgsConstructor
public class PatrolPointsController {
    private final PatrolPointsService PatrolPointsService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('sys:point:page')")
    public Result<PageResult<PatrolPointsVO>> page(@ParameterObject @Valid PatrolPointsQuery query){
        PageResult<PatrolPointsVO> page = PatrolPointsService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "详情信息")
//    @PreAuthorize("hasAuthority('sys:point:info')")
    public Result<PatrolPointsVO> get(@PathVariable("id") Long id){
        PatrolPointsEntity entity = PatrolPointsService.getById(id);

        return Result.ok(PatrolPointsConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "添加")
//    @PreAuthorize("hasAuthority('sys:points:save')")
    public Result<String> save(@RequestBody PatrolPointsVO vo){
        PatrolPointsService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('sys:point:update')")
    public Result<String> update(@RequestBody @Valid PatrolPointsVO vo){
        PatrolPointsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('sys:point:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        PatrolPointsService.delete(idList);

        return Result.ok();
    }
}