package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.query.DoorQuery;
import com.soft2242.one.service.DoorService;
import com.soft2242.one.vo.DoorSettingVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
* 门禁管理
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@RestController
@RequestMapping("smart/doorSetting")
@Tag(name="门禁管理")
@AllArgsConstructor
public class DoorSettingController {
    private final DoorService doorService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:door:page')")
    public Result<PageResult<DoorSettingVO>> page(@ParameterObject @Valid DoorQuery query){
        return Result.ok(doorService.getDoorSettingPage(query));
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:door:update')")
    public Result<String> update(@RequestBody @Valid DoorSettingVO vo){
        doorService.changeSetting(vo);

        return Result.ok();
    }
}