package com.soft2242.one.enums;

import lombok.Getter;

/**
 * @author : Flobby
 * @program : community-admin-api
 * @description : 禁用启用枚举
 * @create : 2023-05-25 16:28
 **/

@Getter
public enum EnabledEnumFlag {

    ENABLED(0, "启用"),
    DISABLED(1, "禁用");

    EnabledEnumFlag(int value, String des) {
        this.value = value;
        this.des = des;
    }

    int value;
    String des;
}
