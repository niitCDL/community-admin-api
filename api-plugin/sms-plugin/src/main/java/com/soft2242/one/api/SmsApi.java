package com.soft2242.one.api;

/**
 * 短信接口
 */
public interface SmsApi {
    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param key    redis key
     * @param value  redis value
     * @return 发送结果
     */
    boolean sendCode(String mobile, String key, String value);

    /**
     * 验证
     *
     * @param mobile 手机号
     * @param code   验证码
     * @return 验证结果
     */
    boolean verifyCode(String mobile, String code);
}