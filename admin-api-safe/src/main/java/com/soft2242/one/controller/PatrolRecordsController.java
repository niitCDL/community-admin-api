package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.vo.PatrolRecordsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 巡更记录表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("safe/record")
@Tag(name="巡更记录")
@AllArgsConstructor
public class PatrolRecordsController {
    private final PatrolRecordsService tPatrolRecordsService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('safe:point:record:page')")
    public Result<PageResult<PatrolRecordsVO>> page(@ParameterObject @Valid PatrolRecordsQuery query){
        System.out.println(query.toString());
        PageResult<PatrolRecordsVO> page = tPatrolRecordsService.page(query);
        System.out.println("=========================="+page);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:records:info')")
    public Result<PatrolRecordsVO> get(@PathVariable("id") Long id){
        PatrolRecordsEntity entity = tPatrolRecordsService.getById(id);

        return Result.ok(PatrolRecordsConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:records:save')")
    public Result<String> save(@RequestBody PatrolRecordsVO vo){
        tPatrolRecordsService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:records:update')")
    public Result<String> update(@RequestBody @Valid PatrolRecordsVO vo){
        tPatrolRecordsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:records:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tPatrolRecordsService.delete(idList);

        return Result.ok();
    }
}