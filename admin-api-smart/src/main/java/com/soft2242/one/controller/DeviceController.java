package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.DeviceConvert;
import com.soft2242.one.entity.DeviceEntity;
import com.soft2242.one.query.DeviceQuery;
import com.soft2242.one.service.DeviceService;
import com.soft2242.one.vo.DeviceVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 设备表
*
* @author Flobby
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("smart/device")
@Tag(name="设备表")
@AllArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("page")
    @Operation(summary = "分页")
    // @PreAuthorize("hasAuthority('smart:device:page')")
    public Result<PageResult<DeviceVO>> page(@ParameterObject @Valid DeviceQuery query){
        PageResult<DeviceVO> page = deviceService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    // @PreAuthorize("hasAuthority('smart:device:info')")
    public Result<DeviceVO> get(@PathVariable("id") Long id){
        DeviceEntity entity = deviceService.getById(id);

        return Result.ok(DeviceConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    // @PreAuthorize("hasAuthority('smart:device:save')")
    public Result<String> save(@RequestBody DeviceVO vo){
        deviceService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    // @PreAuthorize("hasAuthority('smart:device:update')")
    public Result<String> update(@RequestBody @Valid DeviceVO vo){
        deviceService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    // @PreAuthorize("hasAuthority('smart:device:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        deviceService.delete(idList);

        return Result.ok();
    }

    @GetMapping("list")
    @Operation(summary = "全部设备")
    public Result<List<DeviceEntity>> list() {
        return Result.ok(deviceService.list());
    }
}