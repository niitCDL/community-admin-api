package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PatrolPathConvert;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.vo.PatrolPathVO;
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
@Tag(name="巡更路线表")
@AllArgsConstructor
public class PatrolPathController {
    private final PatrolPathService tPatrolPathService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('soft2242:path:page')")
    public Result<PageResult<PatrolPathVO>> page(@ParameterObject @Valid PatrolPathQuery query){
        PageResult<PatrolPathVO> page = tPatrolPathService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:path:info')")
    public Result<PatrolPathVO> get(@PathVariable("id") Long id){
        PatrolPathEntity entity = tPatrolPathService.getById(id);

        return Result.ok(PatrolPathConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:path:save')")
    public Result<String> save(@RequestBody PatrolPathVO vo){
        tPatrolPathService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:path:update')")
    public Result<String> update(@RequestBody @Valid PatrolPathVO vo){
        tPatrolPathService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:path:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tPatrolPathService.delete(idList);

        return Result.ok();
    }
}