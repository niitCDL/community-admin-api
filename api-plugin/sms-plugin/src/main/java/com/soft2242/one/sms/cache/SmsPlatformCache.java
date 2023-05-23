package com.soft2242.one.sms.cache;

import com.soft2242.one.base.common.cache.RedisCache;
import com.soft2242.one.sms.sms.config.SmsConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信平台 Cache
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class SmsPlatformCache {
    private final RedisCache redisCache;

    /**
     * 短信平台轮询KEY
     */
    private final String SMS_ROUND_KEY = "message:sms:round";

    /**
     * 短信平台列表KEY
     */
    private final String SMS_PLATFORM_KEY = "message:sms:platform";

    /**
     * 获取短信轮询值
     */
    public Long getRoundValue() {
        return redisCache.increment(SMS_ROUND_KEY);
    }

    public List<SmsConfig> list() {
        return (List<SmsConfig>) redisCache.get(SMS_PLATFORM_KEY);
    }

    public void save(List<SmsConfig> list) {
        redisCache.set(SMS_PLATFORM_KEY, list);
    }

    public void delete() {
        redisCache.delete(SMS_PLATFORM_KEY);
    }
}
