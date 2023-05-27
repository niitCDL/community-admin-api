//package com.soft2242.one.controller;
//
//import com.soft2242.one.base.common.utils.PageResult;
//import com.soft2242.one.base.common.utils.Result;
//import com.soft2242.one.convert.MallConvert;
//import com.soft2242.one.query.MallQuery;
//import com.soft2242.one.service.IMallService;
//import com.soft2242.one.vo.MallVO;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springdoc.core.annotations.ParameterObject;
//import org.springframework.web.bind.annotation.*;
//
//
///**
// * Author: James
// * Date: 2023/5/26 16:19
// * Describe:
// */
//@RestController
//@RequestMapping("soft2242/shop")
//@Tag(name = "商铺管理")
//@AllArgsConstructor
//public class MallsController {
//
//    private final IMallService mallService;
//
////    分页查询
//    @GetMapping("page")
//    @Operation(summary = "分页查询")
//    public Result<PageResult<MallVO>> page(@ParameterObject @Valid MallQuery query){
//
//        PageResult<MallVO> page = mallService.page(query);
//        return Result.ok(page);
//    }
//
//    @GetMapping("search/{id}")
//    @Operation(summary = "查询商铺")
//    public Result<MallVO> search(@PathVariable("id") Long id){
//        return Result.ok(MallConvert.INSTANCE.convert(mallService.getById(id)));
//    }
//
//    @PostMapping
//    @Operation(summary = "创建商铺")
//    public Result<MallVO> create(@RequestBody @Valid MallVO vo){
//        mallService.save(vo);
//        return Result.ok();
//    }
//
//
//}
