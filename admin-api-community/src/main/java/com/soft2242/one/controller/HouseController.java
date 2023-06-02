package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.convert.HouseConvert;
import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.House;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.HouseQuery;
import com.soft2242.one.service.IHouseService;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.HouseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 房屋表 前端控制器
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@RestController
@RequestMapping("/sys/house")
@Tag(name = "房屋管理")
@AllArgsConstructor
public class HouseController {
    private final IHouseService houseService;

    @GetMapping("page")
    @Operation(summary = "房屋分页")
    //@PreAuthorize("hasAuthority('sys:building:page')")
    public Result<PageResult<HouseVO>> page(@ParameterObject @Valid HouseQuery query) {
        PageResult<HouseVO> page = houseService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "房屋列表")
    public Result<List<HouseVO>> list() {
        List<HouseVO> list = houseService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "房屋信息")
    //@PreAuthorize("hasAuthority('sys:building:info')")
    public Result<HouseVO> get(@PathVariable("id") Long id) {
        House entity = houseService.getById(id);
        return Result.ok(HouseConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增房屋")
    //@PreAuthorize("hasAuthority('sys:community:save')")
    public Result<String> save(@RequestBody HouseVO vo) {
        houseService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改房屋")
    //@PreAuthorize("hasAuthority('sys:community:update')")
    public Result<String> update(@RequestBody @Valid HouseVO vo) {
        houseService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除房屋")
    //@PreAuthorize("hasAuthority('sys:building:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        houseService.delete(ids);
        return Result.ok("删除成功");
    }
    @GetMapping("export")
    @Operation(summary = "导出房屋")
    //@PreAuthorize("hasAuthority('sys:building:export')")
    public void export(){
        houseService.export();
    }

    @PostMapping("import")
    @Operation(summary = "导入房屋")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        houseService.importByExcel(file);
        return Result.ok();
    }

}
