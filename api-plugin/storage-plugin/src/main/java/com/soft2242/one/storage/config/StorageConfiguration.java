package com.soft2242.one.storage.config;

import com.soft2242.one.storage.enums.StorageTypeEnum;
import com.soft2242.one.storage.properties.StorageProperties;
import com.soft2242.one.storage.service.AliyunStorageService;
import com.soft2242.one.storage.service.LocalStorageService;
import com.soft2242.one.storage.service.MinioStorageService;
import com.soft2242.one.storage.service.StorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 存储配置文件
 *
 * @author mqxu
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class StorageConfiguration {

    @Bean
    public StorageService storageService(StorageProperties properties) {
        if (properties.getConfig().getType() == StorageTypeEnum.LOCAL) {
            return new LocalStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.ALIYUN) {
            return new AliyunStorageService(properties);
        } else if (properties.getConfig().getType() == StorageTypeEnum.MINIO) {
            return new MinioStorageService(properties);
        }
        return null;
    }
}
