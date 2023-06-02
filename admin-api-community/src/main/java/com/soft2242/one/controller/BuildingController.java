package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.entity.Building;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.service.IBuildingService;
import com.soft2242.one.storage.service.StorageService;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.SysFileUploadVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 楼宇表 前端控制器
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@RestController
@RequestMapping("/sys/building")
@Tag(name = "楼宇管理")
@AllArgsConstructor
public class BuildingController {
    private final IBuildingService buildingService;



    @GetMapping("page")
    @Operation(summary = "楼宇分页")
    //@PreAuthorize("hasAuthority('sys:building:page')")
    public Result<PageResult<BuildingVO>> page(@ParameterObject @Valid BuildingQuery query) {
        PageResult<BuildingVO> page = buildingService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "楼宇列表")
    public Result<List<BuildingVO>> list() {
        List<BuildingVO> list = buildingService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "楼宇信息")
    //@PreAuthorize("hasAuthority('sys:building:info')")
    public Result<BuildingVO> get(@PathVariable("id") Long id) {
        Building entity = buildingService.getById(id);
        return Result.ok(BuildingConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增楼宇")
    //@PreAuthorize("hasAuthority('sys:building:save')")
    public Result<String> save(@RequestBody BuildingVO vo) {
        buildingService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改楼宇")
    //@PreAuthorize("hasAuthority('sys:building:update')")
    public Result<String> update(@RequestBody @Valid BuildingVO vo) {
        buildingService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除楼宇")
    //@PreAuthorize("hasAuthority('sys:building:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        buildingService.delete(ids);
        return Result.ok("删除成功");
    }

    @GetMapping("export")
    @Operation(summary = "导出楼宇")
    //@PreAuthorize("hasAuthority('sys:building:export')")
    public void export(){
        buildingService.export();
    }

    @PostMapping("import")
    @Operation(summary = "导入楼宇")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        buildingService.importByExcel(file);
        return Result.ok();
    }
}
