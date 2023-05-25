package com.soft2242.one.system.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.soft2242.one.system.convert.SysDepartmentConvert;
import com.soft2242.one.system.entity.SysDepartmentEntity;
import com.soft2242.one.system.service.SysDepartmentService;
import com.soft2242.one.system.query.SysDepartmentQuery;
import com.soft2242.one.system.vo.SysDepartmentVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 部门
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("sys/org")
@Tag(name="部门管理")
@AllArgsConstructor
public class SysDepartmentController {
    private final SysDepartmentService sysDepartmentService;

    @GetMapping("list")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:org:list')")
    public Result<List<SysDepartmentVO>> page(){
        List<SysDepartmentVO> list = sysDepartmentService.getList();

        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:org:info')")
    public Result<SysDepartmentVO> get(@PathVariable("id") Long id){
        SysDepartmentEntity entity = sysDepartmentService.getById(id);

        return Result.ok(SysDepartmentConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:org:save')")
    public Result<String> save(@RequestBody SysDepartmentVO vo){
        sysDepartmentService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:org:update')")
    public Result<String> update(@RequestBody @Valid SysDepartmentVO vo){
        sysDepartmentService.update(vo);

        return Result.ok();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:org:delete')")
    public Result<String> delete(@PathVariable("id") Long id){
        sysDepartmentService.delete(id);

        return Result.ok();
    }
}