package com.soft2242.one.base.common.cache;

/**
 * Redis Key管理
 *
 * @author moqi
 */
public class RedisKeys {

    /**
     * 验证码Key
     */
    public static String getCaptchaKey(String key) {
        return "sys:captcha:" + key;
    }

    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }

}
