package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolPlanConvert;
import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.query.PatrolPlanQuery;
import com.soft2242.one.service.PatrolPlanService;
import com.soft2242.one.vo.PatrolPlanVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 巡更计划表
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("soft2242/plan")
@Tag(name="巡更计划表")
@AllArgsConstructor
public class PatrolPlanController {
    private final PatrolPlanService patrolPlanService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('soft2242:plan:page')")
    public Result<PageResult<PatrolPlanVO>> page(@ParameterObject @Valid PatrolPlanQuery query){
        PageResult<PatrolPlanVO> page = patrolPlanService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:plan:info')")
    public Result<PatrolPlanVO> get(@PathVariable("id") Long id){
        PatrolPlanEntity entity = patrolPlanService.getById(id);

        return Result.ok(PatrolPlanConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:plan:save')")
    public Result<String> save(@RequestBody PatrolPlanVO vo){
        patrolPlanService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:plan:update')")
    public Result<String> update(@RequestBody @Valid PatrolPlanVO vo){
        patrolPlanService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:plan:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        patrolPlanService.delete(idList);

        return Result.ok();
    }
}