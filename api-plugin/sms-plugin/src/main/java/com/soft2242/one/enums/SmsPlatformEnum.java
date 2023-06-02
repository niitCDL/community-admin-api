package com.soft2242.one.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短信平台枚举
 */
@Getter
@AllArgsConstructor
public enum SmsPlatformEnum {
    /**
     * 阿里云
     */
    ALIYUN(0),
    /**
     * 腾讯云
     */
    TENCENT(1);

    private final int value;

}