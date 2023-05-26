package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.ActivityTypeConvert;
import com.soft2242.one.entity.ActivityType;
import com.soft2242.one.query.ActivityTypeQuery;
import com.soft2242.one.service.ActivityTypeService;
import com.soft2242.one.vo.ActivityTypeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;


/**
 * 活动分类
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@RestController
@RequestMapping("soft2242/activity/type")
@Tag(name = "活动分类")
@AllArgsConstructor
public class ActivityTypeController {
    private final ActivityTypeService activityTypeService;

    @GetMapping("page")
    @Operation(summary = "分页查询")
//    @PreAuthorize("hasAuthority('soft2242:type:page')")
    public Result<PageResult<ActivityTypeVO>> page(@ParameterObject @Valid ActivityTypeQuery query) {
        PageResult<ActivityTypeVO> page = activityTypeService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "查询信息")
//    @PreAuthorize("hasAuthority('soft2242:type:info')")
    public Result<ActivityTypeVO> get(@PathVariable("id") Long id) {
        ActivityType entity = activityTypeService.getById(id);

        return Result.ok(ActivityTypeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:type:save')")
    public Result<String> save(@RequestBody ActivityTypeVO vo) {
        activityTypeService.save(vo);

        return Result.ok();
    }

    @PutMapping("delete/{id}")
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:type:update')")
    public Result<String> update(@PathVariable("id") Long id) {
        ActivityType entity = activityTypeService.getById(id);
        entity.setDeleted(1);
        ActivityTypeVO vo = ActivityTypeConvert.INSTANCE.convert(entity);
        activityTypeService.update(vo);
        return Result.ok();
    }

    //    逻辑删除
    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:type:update')")
    public Result<String> update(@RequestBody @Valid ActivityTypeVO vo) {
        activityTypeService.update(vo);

        return Result.ok();
    }

//    @DeleteMapping
//    @Operation(summary = "删除")
////    @PreAuthorize("hasAuthority('soft2242:type:delete')")
//    public Result<String> delete(@RequestBody List<Long> idList){
//        activityTypeService.delete(idList);
//        return Result.ok();
//    }
}