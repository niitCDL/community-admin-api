package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PassRecordConvert;
import com.soft2242.one.entity.PassRecordEntity;
import com.soft2242.one.query.PassRecordQuery;
import com.soft2242.one.service.PassRecordService;
import com.soft2242.one.vo.PassRecordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
* 通行记录
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@RestController
@RequestMapping("smart/pass")
@Tag(name="通行记录")
@AllArgsConstructor
public class PassRecordController {
    private final PassRecordService passRecordService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('smart:pass:page')")
    public Result<PageResult<PassRecordVO>> page(@ParameterObject @Valid PassRecordQuery query){
        PageResult<PassRecordVO> page = passRecordService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('smart:pass:info')")
    public Result<PassRecordVO> get(@PathVariable("id") Long id){
        PassRecordEntity entity = passRecordService.getById(id);

        return Result.ok(PassRecordConvert.INSTANCE.convert(entity));
    }

}