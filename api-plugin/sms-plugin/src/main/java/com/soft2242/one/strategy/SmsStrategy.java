package com.soft2242.one.strategy;

import java.util.Map;
/**
 * 短信策略接口
 */
public interface SmsStrategy {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 参数
     */
    void send(String mobile, Map<String, String> params);
}
