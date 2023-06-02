package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.BuildingConvert;
import com.soft2242.one.convert.MallConvert;
import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.Mall;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.MallQuery;
import com.soft2242.one.service.IBuildingService;
import com.soft2242.one.service.IMallService;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.MallVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 商铺表 前端控制器
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@RestController
@RequestMapping("/sys/mall")
@Tag(name = "商铺管理")
@AllArgsConstructor
public class MallController {
    private final IMallService mallService;



    @GetMapping("page")
    @Operation(summary = "商铺分页")
    //@PreAuthorize("hasAuthority('sys:mall:page')")
    public Result<PageResult<MallVO>> page(@ParameterObject @Valid MallQuery query) {
        PageResult<MallVO> page = mallService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "商铺列表")
    public Result<List<MallVO>> list() {
        List<MallVO> list = mallService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "商铺信息")
    //@PreAuthorize("hasAuthority('sys:mall:info')")
    public Result<MallVO> get(@PathVariable("id") Long id) {
        Mall entity = mallService.getById(id);
        return Result.ok(MallConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增商铺")
    //@PreAuthorize("hasAuthority('sys:mall:save')")
    public Result<String> save(@RequestBody MallVO vo) {
        mallService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改商铺")
    //@PreAuthorize("hasAuthority('sys:mall:update')")
    public Result<String> update(@RequestBody @Valid MallVO vo) {
        mallService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除商铺")
    //@PreAuthorize("hasAuthority('sys:mall:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        mallService.delete(ids);
        return Result.ok("删除成功");
    }

    @GetMapping("export")
    @Operation(summary = "导出商铺")
    //@PreAuthorize("hasAuthority('sys:mall:export')")
    public void export(){
        mallService.export();
    }

    @PostMapping("import")
    @Operation(summary = "导入商铺")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        mallService.importByExcel(file);
        return Result.ok();
    }

}
