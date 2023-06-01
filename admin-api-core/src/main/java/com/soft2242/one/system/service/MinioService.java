package com.soft2242.one.system.service;

import com.alibaba.excel.util.StringUtils;
import com.soft2242.one.system.config.MinioConfig;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年06月01日 16:50
 * @Description:
 * @since: 1.0
 */
@Service
@AllArgsConstructor
public class MinioService {
    private MinioConfig minioConfig;

    /**
     * 文件上传
     *
     * @param file 文件
     * @return Boolean
     */
    public String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)){
            throw new RuntimeException();
        }
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        try {
            minioConfig.putObject("samrtcommunity",fileName,"avatar",file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return fileName;
    }

    /**
     * 预览图片
     * @param fileName
     * @return
     */
    public String preview(String fileName){
        return minioConfig.getPreviewFileUrl("samrtcommunity", fileName);
    }

    /**
     * 文件下载
     * @param fileName 文件名称
     * @return Boolean
     */
    public void download(String fileName) {

    }



    /**
     * 删除
     * @param fileName
     * @return
     * @throws Exception
     */
    public boolean remove(String fileName){
       return false;
    }
}
