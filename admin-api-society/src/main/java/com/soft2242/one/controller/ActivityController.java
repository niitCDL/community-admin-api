package com.soft2242.one.controller;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.ActivityConvert;
import com.soft2242.one.entity.Activity;
import com.soft2242.one.query.ActivityQuery;
import com.soft2242.one.service.ActivityService;
import com.soft2242.one.vo.ActivityVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 社区活动
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@RestController
@RequestMapping("soft2242/activity")
@Tag(name = "社区活动")
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('soft2242:activity:page')")
    public Result<PageResult<ActivityVO>> page(@ParameterObject @Valid ActivityQuery query) {
        PageResult<ActivityVO> page = activityService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:activity:info')")
    public Result<ActivityVO> get(@PathVariable("id") Long id) {
        Activity entity = activityService.getById(id);

        return Result.ok(ActivityConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:activity:save')")
    public Result<String> save(@RequestBody ActivityVO vo) {
        activityService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:activity:update')")
    public Result<String> update(@RequestBody @Valid ActivityVO vo) {
        activityService.update(vo);

        return Result.ok();
    }

    //    逻辑删除
    @PutMapping("delete/{id}")
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:activity:update')")
    public Result<String> delete(@PathVariable("id") Long id) {
        Activity entity = activityService.getById(id);
        entity.setDeleted(1);
        ActivityVO vo = ActivityConvert.INSTANCE.convert(entity);
        activityService.update(vo);
        return Result.ok();
    }

}