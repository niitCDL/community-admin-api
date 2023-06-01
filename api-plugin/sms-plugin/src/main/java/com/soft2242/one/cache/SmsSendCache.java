package com.soft2242.one.cache;

import com.soft2242.one.base.common.cache.RedisCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 短信发送缓存
 */
@Service
@AllArgsConstructor
public class SmsSendCache {
    private final RedisCache redisCache;

    /**
     * 获取发送手机短信验证码KEY
     *
     * @param mobile 手机号
     * @return KEY
     */
    private String getCodeKey(String mobile) {
        return "message:sms:code" + mobile;
    }

    public void saveCode(String mobile, String code) {
        String key = getCodeKey(mobile);
        // 保存到Redis，有效期10分钟
        redisCache.set(key, code, 10 * 60);
    }

    public String getCode(String mobile) {
        String key = getCodeKey(mobile);
        return (String) redisCache.get(key);
    }

    public void deleteCode(String mobile) {
        String key = getCodeKey(mobile);
        redisCache.delete(key);
    }
}