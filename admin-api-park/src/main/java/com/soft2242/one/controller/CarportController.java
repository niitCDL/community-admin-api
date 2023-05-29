package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.service.CarportService;
import com.soft2242.one.vo.CarportVO;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.convert.CarportConvert;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName CarportController
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:00
 */
@RestController
@RequestMapping("/sys/carport")
@Tag(name = "车位管理")
@AllArgsConstructor
public class CarportController {

    private final CarportService carportService;

    @GetMapping("page")
    @Operation(summary = "车位分页")
    //@PreAuthorize("hasAuthority('sys:carport:page')")
    public Result<PageResult<CarportVO>> page(@ParameterObject @Valid CarportQuery query) {
        PageResult<CarportVO> page = carportService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "车位列表")
    public Result<List<CarportVO>> list() {
        List<CarportVO> list = carportService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "车位信息")
    //@PreAuthorize("hasAuthority('sys:carport:info')")
    public Result<CarportVO> get(@PathVariable("id") Long id) {
        Carport entity = carportService.getById(id);
        return Result.ok(CarportConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增车位")
    //@PreAuthorize("hasAuthority('sys:carport:save')")
    public Result<String> save(@RequestBody CarportVO vo) {
        carportService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改车位")
    //@PreAuthorize("hasAuthority('sys:carport:update')")
    public Result<String> update(@RequestBody @Valid CarportVO vo) {
        carportService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除车位")
    //@PreAuthorize("hasAuthority('sys:carport:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        carportService.delete(ids);
        return Result.ok("删除成功");
    }
//    @GetMapping("export")
//    @Operation(summary = "导出车位")
//    //@PreAuthorize("hasAuthority('sys:carport:export')")
//    public void export(){
//        carportService.export();
//    }
//
//    @PostMapping("import")
//    @Operation(summary = "导入车位")
//    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return Result.error("请选择需要上传的文件");
//        }
//        carportService.importByExcel(file);
//        return Result.ok();
//    }
}
