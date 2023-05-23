package com.soft2242.one.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * 用户性别状态
 *
 * @author mqxu
 */
@Getter
@AllArgsConstructor
public enum UserGenderEnum {
    /**
     * 未知
     */
    SECRET(0, "未知"),
    /**
     * 男
     */
    MAN(1, "男"),
    /**
     * 女
     */
    WOMEN(2, "女");


    private final int value;
    private final String name;

    public static String getNameByValue(int value) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
