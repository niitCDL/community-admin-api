package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.ParkConvert;
import com.soft2242.one.convert.ParkRecordConvert;
import com.soft2242.one.entity.Park;
import com.soft2242.one.entity.ParkRecord;
import com.soft2242.one.query.ParkQuery;
import com.soft2242.one.query.ParkRecordQuery;
import com.soft2242.one.service.ParkRecordService;
import com.soft2242.one.vo.ParkRecordVO;
import com.soft2242.one.vo.ParkVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ParkRecordController
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 09:14
 */
@RestController
@RequestMapping("sys/record")
@Tag(name="停车记录")
@AllArgsConstructor
public class ParkRecordController {

    private final ParkRecordService parkRecordService;

    @GetMapping("page")
    @Operation(summary = "停车记录分页")
    //@PreAuthorize("hasAuthority('sys:building:page')")
    public Result<PageResult<ParkRecordVO>> page(@ParameterObject @Valid ParkRecordQuery query) {
        PageResult<ParkRecordVO> page = parkRecordService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "停车记录列表")
    public Result<List<ParkRecordVO>> list() {
        List<ParkRecordVO> list = parkRecordService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "停车记录信息")
    //@PreAuthorize("hasAuthority('sys:building:info')")
    public Result<ParkRecordVO> get(@PathVariable("id") Long id) {
        ParkRecord entity = parkRecordService.getById(id);
        return Result.ok(ParkRecordConvert.INSTANCE.convert(entity));
    }
    @GetMapping("/info/{id}")
    @Operation(summary = "停车记录VO信息")
    //@PreAuthorize("hasAuthority('sys:building:info')")
    public Result<ParkRecordVO> info(@PathVariable("id") Long id) {
        ParkRecordVO entity = parkRecordService.getInfo(id);
        return Result.ok(entity);
    }
}
