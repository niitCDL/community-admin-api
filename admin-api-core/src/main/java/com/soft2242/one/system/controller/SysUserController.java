package com.soft2242.one.system.controller;

import cn.hutool.core.util.StrUtil;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.base.security.user.SecurityUser;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.convert.SysUserInfoConvert;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.query.SysUserQuery;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserPasswordVO;
import com.soft2242.one.system.vo.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysUserService sysUserService;

    private final PasswordEncoder passwordEncoder;



    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<SysUserInfoVO> get(@PathVariable("id") Long id) {
        SysUserInfoEntity entity = sysUserService.getUserInfoByAdminId(id);

        SysUserInfoVO vo = SysUserInfoConvert.INSTANCE.convert(entity);

        return Result.ok(vo);
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysUserInfoVO vo) {
        // 新增密码不能为空
        if (StrUtil.isBlank(vo.getPassword())) {
            Result.error("密码不能为空");
        }

        // 密码加密
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));

        // 保存
        sysUserService.save(vo);

        return Result.ok();
    }

    @GetMapping("info")
    @Operation(summary = "登录用户")
    public Result<SysUserVO> info() {
        UserDetail userDetail = SecurityUser.getUser();
        System.out.println(userDetail);
        SysUserVO user = SysUserInfoConvert.INSTANCE.convert(userDetail);
        return Result.ok(user);
    }

    @PutMapping
    @Operation(summary = "修改用户状态")
    public Result changeAccountStatus(Long id,Integer accountStatus) {
        sysUserService.changeAccountStatus(id,accountStatus);
        return Result.ok();
    }

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<SysUserVO>> page(@ParameterObject @Valid SysUserQuery query) {
        PageResult<SysUserVO> page = sysUserService.page(query);
        return Result.ok(page);
    }
    @GetMapping("list")
    @Operation(summary = "用户列表")
    public Result<List<SysUserVO>> list() {
        List<SysUserVO> list = sysUserService.getList();
        return Result.ok(list);
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result<String> delete(@RequestBody List<Long> idList) {
        Long userId = SecurityUser.getUserId();
        if (idList.contains(userId)) {
            return Result.error("不能删除当前登录用户");
        }

        sysUserService.delete(idList);

        return Result.ok();
    }

    /**
     * 修改密码
     * @param vo
     * @return
     */
    @PutMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> password(@RequestBody @Valid SysUserPasswordVO vo) {
        // 原密码不正确
        UserDetail user = SecurityUser.getUser();
        if (!passwordEncoder.matches(vo.getPassword(), user.getPassword())) {
            return Result.error("原密码不正确");
        }

        // 修改密码
        sysUserService.updatePassword(user.getId(), passwordEncoder.encode(vo.getNewPassword()));

        return Result.ok();
    }

    @GetMapping("export")
    @Operation(summary = "导出用户")
    public void export() {
        sysUserService.export();
    }

    @PostMapping("import")
    @Operation(summary = "导入用户")
    public Result<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        sysUserService.importByExcel(file);
        return Result.ok();
    }
}
