package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.DeviceTypeConvert;
import com.soft2242.one.entity.DeviceTypeEntity;
import com.soft2242.one.query.DeviceTypeQuery;
import com.soft2242.one.service.DeviceTypeService;
import com.soft2242.one.vo.DeviceTypeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 设备类别表
*
* @author Flobby 
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("smart/deviceType")
@Tag(name="设备类别")
@AllArgsConstructor
public class DeviceTypeController {
    private final DeviceTypeService deviceTypeService;

    @GetMapping("page")
    @Operation(summary = "分页")
    // @PreAuthorize("hasAuthority('sys:deviceType:page')")
    public Result<PageResult<DeviceTypeVO>> page(@ParameterObject @Valid DeviceTypeQuery query){
        PageResult<DeviceTypeVO> page = deviceTypeService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    // @PreAuthorize("hasAuthority('sys:deviceType:info')")
    public Result<DeviceTypeVO> get(@PathVariable("id") Long id){
        DeviceTypeEntity entity = deviceTypeService.getById(id);

        return Result.ok(DeviceTypeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    // @PreAuthorize("hasAuthority('sys:deviceType:save')")
    public Result<String> save(@RequestBody DeviceTypeVO vo){
        deviceTypeService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    // @PreAuthorize("hasAuthority('sys:deviceType:update')")
    public Result<String> update(@RequestBody @Valid DeviceTypeVO vo){
        deviceTypeService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    // @PreAuthorize("hasAuthority('sys:deviceType:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        deviceTypeService.delete(idList);

        return Result.ok();
    }

    @GetMapping("list")
    @Operation(summary = "全部列表")
    public Result<List<DeviceTypeEntity>> list() {
        return Result.ok(deviceTypeService.availableList());
    }
}