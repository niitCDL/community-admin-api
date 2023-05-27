package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.BillConvert;
import com.soft2242.one.entity.Bill;
import com.soft2242.one.query.BillQuery;
import com.soft2242.one.service.IBillService;
import com.soft2242.one.vo.BillVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author ysh
 * @since 2023-05-25
 */
@RestController
@Tag(name = "账单模块")
@RequestMapping("soft2242/bill")
@AllArgsConstructor
public class BillController {
    private final IBillService billService;

    @GetMapping("page")
    @Operation(summary = "分页查询")
    public Result<PageResult<BillVO>> page(@ParameterObject @Valid BillQuery query) {
        PageResult<BillVO> page = billService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "账单查询")
    public Result<BillVO> get(@PathVariable("id") Long id) {
        Bill entity = billService.getById(id);
        return Result.ok(BillConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "生成订单")
    public Result<String> create(@Valid @RequestBody BillVO vo) {
        billService.save(vo);
        return Result.ok();

    }

    @PutMapping
    @Operation(summary = "修改订单状态")
    public Result<String> update(@Valid @RequestBody BillVO vo) {
        billService.update(vo);
        return Result.ok();
    }

    //    逻辑删除
    @PutMapping("delete/{id}")
    @Operation(summary = "删除订单")
    public Result<String> delete(@PathVariable("id") Long id) {
        Bill entity = billService.getById(id);
        System.out.println("删除订单" + entity);
        entity.setDeleted(1);
        BillVO vo = BillConvert.INSTANCE.convert(entity);
        billService.update(vo);
        return Result.ok();

    }


}
