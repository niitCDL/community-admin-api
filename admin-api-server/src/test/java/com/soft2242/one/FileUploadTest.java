package com.soft2242.one;

import cn.hutool.core.io.IoUtil;
import com.soft2242.one.entity.Building;
import com.soft2242.one.service.IBuildingService;
import com.soft2242.one.service.impl.BuildingServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.soft2242.one.storage.service.StorageService;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class FileUploadTest {

    @Autowired
    private StorageService storageService;

    @Test
    public void uploadTest() throws Exception {
        File file = new File("/Users/moqi/Pictures/000/1.jpeg");
        byte[] data = IoUtil.readBytes(Files.newInputStream(file.toPath()));
        String path = storageService.getPath(file.getName());
        String url = storageService.upload(data, path);
        log.info(url);
    }
    @Resource
    private BuildingServiceImpl buildingService;

}
