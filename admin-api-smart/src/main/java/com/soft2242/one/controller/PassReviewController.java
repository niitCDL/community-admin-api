package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.PassReviewConvert;
import com.soft2242.one.entity.PassReviewEntity;
import com.soft2242.one.query.PassReviewQuery;
import com.soft2242.one.service.PassReviewService;
import com.soft2242.one.vo.PassReviewVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
* 门禁审核
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@RestController
@RequestMapping("smart/review")
@Tag(name="门禁审核")
@AllArgsConstructor
public class PassReviewController {
    private final PassReviewService passReviewService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('smart:review:page')")
    public Result<PageResult<PassReviewVO>> page(@ParameterObject @Valid PassReviewQuery query){
        PageResult<PassReviewVO> page = passReviewService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('smart:review:info')")
    public Result<PassReviewVO> get(@PathVariable("id") Long id){
        PassReviewEntity entity = passReviewService.getById(id);

        return Result.ok(PassReviewConvert.INSTANCE.convert(entity));
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('smart:review:update')")
    public Result<String> update(@RequestBody @Valid PassReviewVO vo){
        passReviewService.update(vo);

        return Result.ok();
    }

}
