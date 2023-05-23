package com.soft2242.one.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserOnlineEnum {

    /**
     * 是
     */
    ONLINE(1, "在线"),
    /**
     * 否
     */
    OFFLINE(0, "离线");

    private final Integer value;
    private final String name;

}
