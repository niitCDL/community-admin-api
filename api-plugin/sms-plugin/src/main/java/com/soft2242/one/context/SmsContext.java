package com.soft2242.one.context;


import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.config.SmsConfig;
import com.soft2242.one.enums.SmsPlatformEnum;
import com.soft2242.one.strategy.AliyunSmsStrategy;
import com.soft2242.one.strategy.SmsStrategy;

import java.util.Map;
/**
 * 短信上下文
 */
public class SmsContext {
    private final SmsStrategy smsStrategy;

    public SmsContext(SmsConfig config) {
        if (config.getPlatform() == SmsPlatformEnum.ALIYUN.getValue()) {
            this.smsStrategy = new AliyunSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.TENCENT.getValue()) {
            // TODO 腾讯云短信发送
            this.smsStrategy = null;
        } else {
            throw new ServerException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsStrategy.send(mobile, params);
    }
}