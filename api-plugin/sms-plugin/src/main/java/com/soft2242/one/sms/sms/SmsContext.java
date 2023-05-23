package com.soft2242.one.sms.sms;


import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.sms.sms.config.SmsConfig;
import com.soft2242.one.sms.enums.SmsPlatformEnum;

import java.util.Map;

/**
 * 短信 Context
 *
 * @author mqxu
 */
public class SmsContext {
    private final SmsStrategy smsStrategy;

    public SmsContext(SmsConfig config) {
        if (config.getPlatform() == SmsPlatformEnum.ALIYUN.getValue()) {
            this.smsStrategy = new AliyunSmsStrategy(config);
        } else {
            throw new ServerException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsStrategy.send(mobile, params);
    }
}
