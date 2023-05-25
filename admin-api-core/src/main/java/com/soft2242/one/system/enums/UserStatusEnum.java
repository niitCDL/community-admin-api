package com.soft2242.one.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 用户状态
 *
 * @author mqxu
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {

    ENABLED(1, "启用"),
    DISABLE(0, "禁用");

    private final int value;
    private final String name;

    public static String getNameByValue(int value) {
        for (UserStatusEnum s : UserStatusEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (UserStatusEnum s : UserStatusEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
