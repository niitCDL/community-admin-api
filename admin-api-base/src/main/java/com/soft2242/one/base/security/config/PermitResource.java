package com.soft2242.one.base.security.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 允许访问的资源
 *
 * @author moqi
 */
@Component
public class PermitResource {
    /**
     * 指定被 Spring Security 忽略的 URL
     */
    @SneakyThrows
    public List<String> getPermitList() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:auth.yml");
        String key = "auth.ignore_urls";

        return getPropertiesList(key, resources);
    }

    private List<String> getPropertiesList(String key, Resource... resources) {
        List<String> list = new ArrayList<>();

        // 解析资源文件
        for (Resource resource : resources) {
            Properties properties = loadYamlProperties(resource);

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String tmpKey = StringUtils.substringBefore(entry.getKey().toString(), "[");
                if (tmpKey.equalsIgnoreCase(key)) {
                    list.add(entry.getValue().toString());
                }
            }
        }
        return list;
    }

    private Properties loadYamlProperties(Resource... resources) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resources);
        factory.afterPropertiesSet();

        return factory.getObject();
    }
}
