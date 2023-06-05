package com.soft2242.one;

import cn.hutool.core.io.IoUtil;
import com.soft2242.one.query.ActivityQuery;
import com.soft2242.one.service.ActivityService;
import com.soft2242.one.service.impl.BuildingServiceImpl;
import com.soft2242.one.storage.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Files;

@SpringBootTest
@Slf4j
public class SocietyAndPaymentTest {

    @Autowired
    private ActivityService activityService;

    @Test
    public void search() throws Exception {
        ActivityQuery activityQuery = new ActivityQuery();
        activityQuery.setPage(1);
        activityQuery.setLimit(2);
//        activityQuery.setCreateTime(new LocalDateTime());
        activityQuery.setEndTime(null);
        System.out.println(activityService.page(activityQuery).getList());
    }
    @Resource
    private BuildingServiceImpl buildingService;

}
