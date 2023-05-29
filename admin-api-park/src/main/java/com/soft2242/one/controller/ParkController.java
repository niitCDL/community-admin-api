package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.ParkConvert;
import com.soft2242.one.entity.Park;
import com.soft2242.one.query.ParkQuery;
import com.soft2242.one.service.ParkService;
import com.soft2242.one.storage.service.StorageService;
import com.soft2242.one.vo.ParkVO;
import com.soft2242.one.vo.SysFileUploadVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* 停车场表
*
* @author Dr.King whfplus7@163.com
* @since 1.0.0 2023-05-29
*/
@RestController
@RequestMapping("sys/park")
@Tag(name="停车场管理")
@AllArgsConstructor
public class ParkController {
    private final ParkService parkService;
    private final StorageService storageService;

    @GetMapping("page")
    @Operation(summary = "停车场分页")
    //@PreAuthorize("hasAuthority('sys:building:page')")
    public Result<PageResult<ParkVO>> page(@ParameterObject @Valid ParkQuery query) {
        PageResult<ParkVO> page = parkService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "停车场列表")
    public Result<List<ParkVO>> list() {
        List<ParkVO> list = parkService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "停车场信息")
    //@PreAuthorize("hasAuthority('sys:building:info')")
    public Result<ParkVO> get(@PathVariable("id") Long id) {
        Park entity = parkService.getById(id);
        return Result.ok(ParkConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增停车场")
    //@PreAuthorize("hasAuthority('sys:building:save')")
    public Result<String> save(@RequestBody ParkVO vo) {
        parkService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改停车场")
    //@PreAuthorize("hasAuthority('sys:building:update')")
    public Result<String> update(@RequestBody @Valid ParkVO vo) {
        parkService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除停车场")
    //@PreAuthorize("hasAuthority('sys:building:delete')")
    public Result<String> delete(@RequestBody(required = false) List<Long> ids) {
        parkService.delete(ids);
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