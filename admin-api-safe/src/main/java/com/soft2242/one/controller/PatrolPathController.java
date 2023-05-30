package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolPathConvert;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.service.InspectionItemPathService;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.service.PatrolPointsService;
import com.soft2242.one.service.PointsPathService;
import com.soft2242.one.vo.ComAndPathVO;
import com.soft2242.one.vo.InspectionItemVO;
import com.soft2242.one.vo.PatrolPathVO;
import com.soft2242.one.vo.PatrolPointsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 巡更路线表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@RestController
@RequestMapping("safe/path")
@Tag(name = "巡更路线")
@AllArgsConstructor
public class PatrolPathController {
    private final PatrolPathService PatrolPathService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('safe:path:page')")
    public Result<PageResult<PatrolPathVO>> page(@ParameterObject @Valid PatrolPathQuery query) {
//        System.out.println("eeeeeeeeeeeeeeeeeeeeeeee"+query);
        PageResult<PatrolPathVO> page = PatrolPathService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('safe:path:info')")
    public Result<PatrolPathVO> get(@PathVariable("id") Long id) {
//        System.out.println("+++++++++++++++++++++++++++++++++"+id);
        PatrolPathVO vo = PatrolPathService.getPathById(id);
//        System.out.println("+++++++++++++++++++++++++++++++++"+vo);
        return Result.ok(vo);

    }


    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('safe:path:save')")
    public Result<String> save(@RequestBody PatrolPathVO vo) {
//        System.out.println("你好斤斤计较急急急急急急急急急急急急急急急"+vo);
        PatrolPathService.save(vo);
//        pointsPathService.saveOrUpdate(vo.getPointIds(), vo.getId());
        return Result.ok();
    }


    @GetMapping("points/{communityId}")
    @Operation(summary = "获取所有巡更点")
    public Result<List<PatrolPointsVO>> searchPoints(@PathVariable("communityId") Long communityId) {
        List<PatrolPointsVO> patrolPointsVOS = PatrolPathService.searchPoints(communityId);
        return Result.ok(patrolPointsVOS);
    }

    @GetMapping("items/{communityId}")
    @Operation(summary = "获取所有巡更项目")
    public Result<List<InspectionItemVO>> searchItems(@PathVariable("communityId") Long communityId) {
        List<InspectionItemVO> inspectionItemVOS = PatrolPathService.searchItems(communityId);
        return Result.ok(inspectionItemVOS);
    }

    @GetMapping("communityid")
    @Operation(summary = "获取小区的巡更路线")
    public Result<List<ComAndPathVO>> getPlanListByCommunityId() {
        List<ComAndPathVO> commAndPath = PatrolPathService.getCommAndPath();
        return Result.ok(commAndPath);
    }


    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('safe:path:update')")
    public Result<String> update(@RequestBody @Valid PatrolPathVO vo) {
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+vo);
        PatrolPathService.update(vo);
        return Result.ok();
    }


    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('safe:path:delete')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        PatrolPathService.delete(idList);
        return Result.ok();
    }
}