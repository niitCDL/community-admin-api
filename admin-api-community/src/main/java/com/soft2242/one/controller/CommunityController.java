package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.CommunityConvert;
import com.soft2242.one.entity.Community;
import com.soft2242.one.query.CommunityQuery;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.storage.service.StorageService;
import com.soft2242.one.vo.CommunityVO;
import com.soft2242.one.vo.SysFileUploadVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 社区表 前端控制器
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@RestController
@RequestMapping("/sys/community")
@Tag(name = "社区管理")
@AllArgsConstructor
public class CommunityController {
    private final ICommunityService communityService;
    private final StorageService storageService;


    @GetMapping("page")
    @Operation(summary = "社区分页")
    @PreAuthorize("hasAuthority('sys:community:page')")
    public Result<PageResult<CommunityVO>> page(@ParameterObject @Valid CommunityQuery query) {
        PageResult<CommunityVO> page = communityService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "社区列表")
    public Result<List<CommunityVO>> list() {
        List<CommunityVO> list = communityService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "社区信息")
    @PreAuthorize("hasAuthority('sys:community:info')")
    public Result<CommunityVO> get(@PathVariable("id") Long id) {
        Community entity = communityService.getById(id);
        return Result.ok(CommunityConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增社区")
    //@PreAuthorize("hasAuthority('sys:community:save')")
    public Result<String> save(@RequestBody CommunityVO vo) {
        communityService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改社区")
    //@PreAuthorize("hasAuthority('sys:community:update')")
    public Result<String> update(@RequestBody @Valid CommunityVO vo) {
        communityService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除社区")
    //@PreAuthorize("hasAuthority('sys:community:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        communityService.delete(ids);
        return Result.ok("删除成功");
    }
    @PostMapping("upload")
    @Operation(summary = "上传")
    public Result<SysFileUploadVO> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        // 上传路径
        String path = storageService.getPath(file.getOriginalFilename());
        // 上传文件
        String url = storageService.upload(file.getBytes(), path);
        SysFileUploadVO vo = new SysFileUploadVO();
        vo.setUrl(url);
        vo.setSize(file.getSize());
        vo.setName(file.getOriginalFilename());
        vo.setPlatform(storageService.properties.getConfig().getType().name());
        return Result.ok(vo);
    }

}
