package com.soft2242.one.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.soft2242.one.convert.UserConvert;
import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.service.UserService;
import com.soft2242.one.query.UserQuery;
import com.soft2242.one.vo.UserVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 用户信息表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@RestController
@RequestMapping("one/user")
@Tag(name="用户信息表")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('one:user:page')")
    public Result<PageResult<UserVO>> page(@ParameterObject @Valid UserQuery query){
        PageResult<UserVO> page = userService.page(query);

        return Result.ok(page);
    }
    @PostMapping("list")
    @Operation(summary = "用户信息获取")
    public Result<List<UserEntity>> list(){
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().select(UserEntity::getRealName,UserEntity::getPhone);
        List<UserEntity> list = userService.list(wrapper);
        return Result.ok(list);
    }
    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('one:user:info')")
    public Result<UserVO> get(@PathVariable("id") Long id){
        UserEntity entity = userService.getById(id);
        return Result.ok(UserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('one:user:save')")
    public Result<String> save(@RequestBody UserVO vo){
        userService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('one:user:update')")
    public Result<String> update(@RequestBody @Valid UserVO vo){
        userService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('one:user:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        userService.delete(idList);

        return Result.ok();
    }
}