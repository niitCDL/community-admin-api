package com.soft2242.one.system.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.system.convert.SysPostConvert;
import com.soft2242.one.system.entity.SysPostEntity;
import com.soft2242.one.system.query.SysPostQuery;
import com.soft2242.one.system.service.SysPostService;
import com.soft2242.one.system.vo.SysPostVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sys/post")
@Tag(name = "岗位管理")
@AllArgsConstructor
public class SysPostController {

    private final SysPostService sysPostService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:post:page')")
    public Result<PageResult<SysPostVO>> list(@ParameterObject @Valid SysPostQuery query){
        PageResult<SysPostVO> page = sysPostService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "岗位列表")
    @PreAuthorize("hasAuthority('sys:post:list')")
    public Result<List<SysPostVO>> list(){
        List<SysPostVO> list = sysPostService.getList();
        return Result.ok(list);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:org:info')")
    public Result<SysPostVO> get(@PathVariable("id") Long id){
        SysPostEntity entity = sysPostService.getById(id);

        return Result.ok(SysPostConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:org:save')")
    public Result<String> save(@RequestBody SysPostVO vo){
        sysPostService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:org:update')")
    public Result<String> update(@RequestBody @Valid SysPostVO vo){
        sysPostService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:org:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysPostService.delete(idList);

        return Result.ok();
    }
}
