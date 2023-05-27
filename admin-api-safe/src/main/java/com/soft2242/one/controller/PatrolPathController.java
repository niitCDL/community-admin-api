package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolPathConvert;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 巡更路线表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("sys/path/index")
@Tag(name="巡更路线")
@AllArgsConstructor
public class PatrolPathController {
    private final PatrolPathService PatrolPathService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('soft2242:path:page')")
    public Result<PageResult<PatrolPathVO>> page(@ParameterObject @Valid PatrolPathQuery query){
        PageResult<PatrolPathVO> page = PatrolPathService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:path:info')")
    public Result<PatrolPathVO> get(@PathVariable("id") Long id){
        PatrolPathEntity entity = PatrolPathService.getById(id);

        return Result.ok(PatrolPathConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:path:save')")
    public Result<String> save(@RequestBody PatrolPathVO vo){
        PatrolPathService.save(vo);
        return Result.ok();
    }

    @GetMapping("communties")
    @Operation(summary = "获取所有小区id和名称")
    public Result<List<CommunityVO>> searchCommunity(){
        List<CommunityVO> communityVOS = PatrolPathService.searchCommunity();
        return Result.ok(communityVOS);
    }

    @GetMapping("points")
    @Operation(summary = "获取所有巡更点")
    public Result<List<PatrolPointsVO>> searchPoints(){
        List<PatrolPointsVO> patrolPointsVOS = PatrolPathService.searchPoints();
        return Result.ok(patrolPointsVOS);
    }
    @GetMapping("plans")
    @Operation(summary = "获取所有巡更项目")
    public Result<List<InspectionItemVO>> searchPlans(){
        List<InspectionItemVO> inspectionItemVOS = PatrolPathService.searchItems();
        return Result.ok(inspectionItemVOS);
    }

    @GetMapping("communityid")
    @Operation(summary = "获取小区的巡更路线")
    public Result<List<ComAndPathVO>> getPlanListByCommunityId(){
        List<ComAndPathVO> commAndPath = PatrolPathService.getCommAndPath();
        return Result.ok(commAndPath);
    }



    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:path:update')")
    public Result<String> update(@RequestBody @Valid PatrolPathVO vo){
        PatrolPathService.update(vo);
        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:path:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        PatrolPathService.delete(idList);
        return Result.ok();
    }
}