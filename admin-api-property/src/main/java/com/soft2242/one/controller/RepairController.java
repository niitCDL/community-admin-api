package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.RepairConvert;
import com.soft2242.one.entity.Community;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.service.RepairService;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.utils.MyUtils;
import com.soft2242.one.vo.ComplaintVO;
import com.soft2242.one.vo.RepairVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

/**
* 报修表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-26
*/
@RestController
@RequestMapping("property/repair")
@Tag(name="报修表")
@AllArgsConstructor
public class RepairController {
    private final RepairService repairService;
    private final SysUserService sysUserService;
    private final ICommunityService communityService;
    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('soft2242:repair:page')")
    public Result<PageResult<RepairVO>> page(@ParameterObject @Valid RepairQuery query){
        PageResult<RepairVO> page = repairService.page(query);
        List<RepairVO> list = page.getList();
        for (RepairVO vo: list) {
            String employees = vo.getEmployees();
            vo.setEmployeeIds(MyUtils.convertToArray(employees));
            String[] employeeIds = vo.getEmployeeIds();
            if (employeeIds != null) {
                ArrayList<String> names = new ArrayList<String>();
                for (String employeeId : employeeIds) {
                    //登录用户的信息来获取
                    SysUserInfoEntity entity = sysUserService.getUserInfoByAdminId(Long.valueOf(employeeId));
                    names.add(entity.getRealName());
                }
                vo.setEmployeeNames(names.toArray(new String[names.size()]));
            }

        }
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('soft2242:repair:info')")
    public Result<RepairVO> get(@PathVariable("id") Long id){
        RepairEntity entity = repairService.getById(id);

        return Result.ok(RepairConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('soft2242:repair:save')")
    public Result<String> save(@RequestBody RepairVO vo){
        repairService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('soft2242:repair:update')")
    public Result<String> update(@RequestBody @Valid RepairVO vo){
        repairService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('soft2242:repair:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        repairService.delete(idList);

        return Result.ok();
    }
}
