package com.soft2242.one.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.OrderConvert;
import com.soft2242.one.entity.Order;
import com.soft2242.one.query.OrderQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.service.IHouseService;
import com.soft2242.one.service.IOrderService;
import com.soft2242.one.vo.CommunityVO;
import com.soft2242.one.vo.HouseVO;
import com.soft2242.one.vo.OrderRecordVO;
import com.soft2242.one.vo.OrderVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.PipedOutputStream;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */

@RestController
@Tag(name = "订单模块")
@RequestMapping("soft2242/order")
@AllArgsConstructor
public class OrderController {

    private final IOrderService orderSevice;
    private final IHouseService houseService;

    private final ICommunityService communityService;



    @GetMapping("page")
    @Operation(summary = "分页查询")
    public Result<PageResult<OrderVO>> page(@ParameterObject @Valid OrderQuery query) {
//        VO进行多表查询插入连表字段：插入房屋表的房屋编号和小区字段
        PageResult<OrderVO> page = orderSevice.page(query);
        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "账单查询")
    public Result<OrderVO> get(@PathVariable("id") Long id) {
        Order entity = orderSevice.getById(id);
        return Result.ok(OrderConvert.INSTANCE.convert(entity));
    }


    @PostMapping
    @Operation(summary = "生成订单")
    public Result<String> create(@Valid @RequestBody OrderVO vo) {
        orderSevice.save(vo);
        return Result.ok();

    }

    @PutMapping
    @Operation(summary = "修改订单状态")
    public Result<String> update(@Valid @RequestBody OrderVO vo) {
        orderSevice.update(vo);
        return Result.ok();
    }

    @PutMapping("delete/{id}")
    @Operation(summary = "删除订单")
    public Result<String> delete(@PathVariable @Valid Long id) {
        Order entity = orderSevice.getById(id);
        entity.setDeleted(1);
        orderSevice.update(OrderConvert.INSTANCE.convert(entity));
        return Result.ok();
    }


    //    批量导入账单
    @PostMapping("import")
    @Operation(summary = "批量导入订单")
    public Result<String> create(@RequestParam MultipartFile file) {
        if (file.isEmpty())
            return Result.error("请选择要导入的文件！");
        orderSevice.importByExcel(file);
        return Result.ok();

    }

    @GetMapping("export")
    @Operation(summary = "批量导出订单")
    public void export() {
        orderSevice.export();
    }


    @DeleteMapping
    @Operation(summary = "批量删除")
//    @PreAuthorize("hasAuthority('soft2242:type:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        orderSevice.delete(idList);
        return Result.ok();
    }
    @GetMapping("list")
    @Operation(summary = "获取房屋列表")
    public Result<List<HouseVO>> list() {
        List<HouseVO> list = houseService.getList();
        return Result.ok(list);
    }
    @GetMapping("community")
    @Operation(summary = "获取小区列表")
    public Result<List<CommunityVO>> communityList() {
        List<CommunityVO> list = communityService.getList();
        return Result.ok(list);
    }

    @GetMapping("orderList")
    @Operation(summary = "订单列表")
    public Result<List<Order>> orderList() {
        List<Order> list = orderSevice.getList();
        return Result.ok(list);
    }

    @GetMapping("money/{id}")
    @Operation(summary = "根据房屋查询账单")
    public Result<List<OrderVO>> getByHouseNum(@PathVariable("id") Long id) {
        List<OrderVO> orderVOS = OrderConvert.INSTANCE.convertList(orderSevice.findByHouseId(id));
//        根据房屋number查询账单
        return Result.ok(orderVOS);
    }

    @GetMapping("record")
    @Operation(summary = "统计账单")
    public Result<List<OrderRecordVO>> getRecord() {
        return Result.ok(orderSevice.getRecordList());
    }



}
