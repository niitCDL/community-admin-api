package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolPointsConvert;
import com.soft2242.one.dao.CommunityDao;
import com.soft2242.one.entity.Community;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.service.PatrolPointsService;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.CommunityVO;
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
@RequestMapping("safe/point")
@Tag(name="巡更点")
@AllArgsConstructor
public class PatrolPointsController {
    private final PatrolPointsService PatrolPointsService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('safe:point:page')")
    public Result<PageResult<PatrolPointsVO>> page(@ParameterObject @Valid PatrolPointsQuery query){
        PageResult<PatrolPointsVO> page = PatrolPointsService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "详情信息")
    @PreAuthorize("hasAuthority('safe:point:info')")
    public Result<PatrolPointsVO> get(@PathVariable("id") Long id){
        PatrolPointsVO vo = PatrolPointsService.getById(id);
        return Result.ok(vo);
    }





    @PostMapping
    @Operation(summary = "添加")
    @PreAuthorize("hasAuthority('safe:point:save')")
    public Result<String> save(@RequestBody PatrolPointsVO vo){
        PatrolPointsService.save(vo);
        return Result.ok();
    }

    @GetMapping("communties")
    @Operation(summary = "获取所有小区id和名称")
    public Result<List<CommunityVO>> searchCommunity(){
        List<CommunityVO> communityVOS = PatrolPointsService.searchCommunity();
        return Result.ok(communityVOS);
    }
    @GetMapping("buildings/{communityId}")
    @Operation(summary = "根据communtiyId查询所有的楼宇信息")
    public  Result<List<BuildingVO>> searchBuildingsByCommuntiyId(@PathVariable("communityId") Long communityId){
        List<BuildingVO> buildingVOS = PatrolPointsService.getByCommuntiyId(communityId);
        return Result.ok(buildingVOS);
    }




    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('safe:point:update')")
    public Result<String> update(@RequestBody @Valid PatrolPointsVO vo){
        PatrolPointsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('safe:point:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        PatrolPointsService.delete(idList);

        return Result.ok();
    }
}