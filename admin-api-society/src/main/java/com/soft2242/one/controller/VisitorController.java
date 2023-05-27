package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.VisitorConvert;
import com.soft2242.one.convert.VisitorInvitationConvert;
import com.soft2242.one.entity.Visitor;
import com.soft2242.one.query.VisitorQuery;
import com.soft2242.one.service.IVisitorInvitationService;
import com.soft2242.one.service.IVisitorService;
import com.soft2242.one.vo.VisitorInvitationVO;
import com.soft2242.one.vo.VisitorVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  前端控制器
 * @author ysh
 * @since 2023-05-25
 */

@RestController
@Tag(name = "访客邀请")
@RequestMapping("soft2242/visitor")
@AllArgsConstructor
public class VisitorController {
    private final IVisitorService visitorService;
    private final IVisitorInvitationService visitorInvitationService;


    @GetMapping("page")
    @Operation(summary = "分页查询访客开门记录")
    public Result<PageResult<VisitorVO>> page(@ParameterObject @Valid VisitorQuery query) {
        PageResult<VisitorVO> page = visitorService.page(query);
        return Result.ok(page);
    }

    @GetMapping("history/{userId}")
    @Operation(summary = "查询访客邀请记录")
    public Result<PageResult<VisitorInvitationVO>> page(@PathVariable("userId") Long userId) {
        PageResult<VisitorInvitationVO> page = visitorInvitationService.getAll(userId);
        return Result.ok(page);
    }

    @GetMapping("history2/{userId}")
    @Operation(summary = "查询访客邀请记录2")
    public Result<PageResult<VisitorInvitationVO>> page2(@PathVariable("userId") Long userId) {
        List<VisitorInvitationVO> list = VisitorInvitationConvert.INSTANCE.convertList(visitorInvitationService.getAll2(userId));
        PageResult<VisitorInvitationVO> page = new PageResult<>(list, list.size());
        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "访客查询")
    public Result<VisitorVO> get(@PathVariable("id") Long id) {
        Visitor entity = visitorService.getById(id);
        return Result.ok(VisitorConvert.INSTANCE.convert(entity));
    }

    @PostMapping("addVisitor")
    @Operation(summary = "生成访客开门记录")
    public Result<String> create(@Valid @RequestBody VisitorVO vo) {
        visitorService.save(vo);
        return Result.ok();

    }

    @PostMapping("addHistory")
    @Operation(summary = "生成访客邀请记录")
    public Result<String> createHistory(@Valid @RequestBody VisitorInvitationVO vo) {
        visitorInvitationService.save(vo);
        return Result.ok();

    }

    @PutMapping
    @Operation(summary = "修改访客开门状态")
    public Result<String> update(@Valid @RequestBody VisitorVO vo) {
        visitorService.update(vo);
        return Result.ok();
    }

}
