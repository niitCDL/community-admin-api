package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.RepairRecordConvert;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.service.RepairRecordService;
import com.soft2242.one.vo.RepairRecordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 报修处理表
*
* @author xuelong
* @since 1.0.0 2023-06-04
*/
@RestController
@RequestMapping("soft2242/record")
@Tag(name="报修处理表")
@AllArgsConstructor
public class RepairRecordController {
    private final RepairRecordService repairRecordService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('soft2242:record:page')")
    public Result<PageResult<RepairRecordVO>> page(@ParameterObject @Valid RepairRecordQuery query){
        PageResult<RepairRecordVO> page = repairRecordService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:record:info')")
    public Result<RepairRecordVO> get(@PathVariable("id") Long id){
        RepairRecordEntity entity = repairRecordService.getById(id);

        return Result.ok(RepairRecordConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:record:save')")
    public Result<String> save(@RequestBody RepairRecordVO vo){
        repairRecordService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:record:update')")
    public Result<String> update(@RequestBody @Valid RepairRecordVO vo){
        repairRecordService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:record:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        repairRecordService.delete(idList);

        return Result.ok();
    }
}
