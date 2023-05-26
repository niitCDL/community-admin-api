package com.soft2242.one.controller;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.common.utils.Result;
import com.soft2242.one.convert.InspectionItemEntityConvert;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.query.InspectionItemQuery;
import com.soft2242.one.service.InspectionItemService;
import com.soft2242.one.storage.service.StorageService;
import com.soft2242.one.vo.FileUploadVO;
import com.soft2242.one.vo.InspectionItemVO;
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
* 巡检项目
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@RestController
@RequestMapping("safe/inspectionitem")
@Tag(name="巡检项目")
@AllArgsConstructor
public class InspectionItemController {
    private final InspectionItemService inspectionItemService;
    private final StorageService storageService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:safe:inspectionitem:page')")
    public Result<PageResult<InspectionItemVO>> page(@ParameterObject @Valid InspectionItemQuery query){
        System.out.println(query);
        PageResult<InspectionItemVO> page = inspectionItemService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:safe:inspectionitem:page')")
    public Result<InspectionItemVO> get(@PathVariable("id") Long id){
        InspectionItemEntity entity = inspectionItemService.getById(id);
        return Result.ok(InspectionItemEntityConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:safe:inspectionitem:add')")
    public Result<String> save(@RequestBody InspectionItemVO vo){
        inspectionItemService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:safe:inspectionitem:update')")
    public Result<String> update(@RequestBody @Valid InspectionItemVO vo){
        inspectionItemService.update(vo);
        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:safe:inspectionitem:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        inspectionItemService.delete(idList);

        return Result.ok();
    }



    @PostMapping("upload")
    @Operation(summary = "项目图片上传")
    public Result<FileUploadVO> upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return Result.error("请选择需要上传的文件");
        }
        // 上传路径
        String path = storageService.getPath(file.getOriginalFilename());
        // 上传文件
        String url = storageService.upload(file.getBytes(), path);
        FileUploadVO vo = new FileUploadVO();
        vo.setUrl(url);
        vo.setSize(file.getSize());
        vo.setName(file.getOriginalFilename());
        vo.setPlatform(storageService.properties.getConfig().getType().name());
        return Result.ok(vo);
    }
}