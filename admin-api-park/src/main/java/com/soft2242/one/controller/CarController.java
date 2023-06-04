package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.CarConvert;
import com.soft2242.one.convert.CarportConvert;
import com.soft2242.one.dao.CarDao;
import com.soft2242.one.entity.Car;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.query.CarQuery;
import com.soft2242.one.query.CarportQuery;
import com.soft2242.one.service.CarService;
import com.soft2242.one.service.CarportService;
import com.soft2242.one.vo.CarVO;
import com.soft2242.one.vo.CarportVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName CarController
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:36
 */
@RestController
@RequestMapping("/sys/car")
@Tag(name = "车辆管理")
@AllArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarDao carDao;

    @GetMapping("page")
    @Operation(summary = "车辆分页")
    //@PreAuthorize("hasAuthority('sys:car:page')")
    public Result<PageResult<CarVO>> page(@ParameterObject @Valid CarQuery query) {
        PageResult<CarVO> page = carService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "车辆列表")
    public Result<List<CarVO>> list() {
        List<CarVO> list = carService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "车辆信息")
    //@PreAuthorize("hasAuthority('sys:car:info')")
    public Result<CarVO> get(@PathVariable("id") Long id) {
        Car entity = carService.getById(id);
        return Result.ok(CarConvert.INSTANCE.convert(entity));
    }
    @GetMapping("/VO/{id}")
    @Operation(summary = "车辆VO信息")
    //@PreAuthorize("hasAuthority('sys:car:info')")
    public Result<CarVO> vo(@PathVariable("id") Long id) {
        CarVO entity = carDao.getInfo(id);
        return Result.ok(entity);
    }

    @PostMapping
    @Operation(summary = "新增车辆")
    //@PreAuthorize("hasAuthority('sys:car:save')")
    public Result<String> save(@RequestBody CarVO vo) {
        carService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改车辆")
    //@PreAuthorize("hasAuthority('sys:car:update')")
    public Result<String> update(@RequestBody @Valid CarVO vo) {
        carService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除车辆")
    //@PreAuthorize("hasAuthority('sys:car:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        carService.delete(ids);
        return Result.ok("删除成功");
    }
    @GetMapping("export")
    @Operation(summary = "导出车辆")
    //@PreAuthorize("hasAuthority('sys:car:export')")
    public void export(){
        carService.export();
    }

    @PostMapping("import")
    @Operation(summary = "导入车辆")
    //@PreAuthorize("hasAuthority('sys:car:import')")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        carService.importByExcel(file);
        return Result.ok();
    }
}
