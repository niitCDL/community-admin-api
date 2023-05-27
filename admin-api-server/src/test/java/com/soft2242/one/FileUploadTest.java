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

    @Test
    void batchInsert() {
        List<Building> user = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Building building = Building.builder()
                    .id(51L+i)
                    .communityId(2L)
                    .buildingName("格正楼")
                    .units(1+i)
                    .usedArea(200+i)
                    .content("格物致知").build();
            user.add(building);
        }
        boolean b = buildingService.saveBatch(user);
        System.out.println(b);
    }
}
