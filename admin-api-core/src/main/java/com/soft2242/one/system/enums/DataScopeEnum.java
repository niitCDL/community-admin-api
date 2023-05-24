package com.soft2242.one.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月24日 14:52
 * @Description:
 * @since: 1.0
 */
@Getter
@AllArgsConstructor
public enum DataScopeEnum {
    /**
     * 全部数据
     */
    ALL(0),
    /**
     * 本机构及子机构数据
     */
    ORG_AND_CHILD(1),
    /**
     * 本机构数据
     */
    ORG_ONLY(2),
    /**
     * 本人数据
     */
    SELF(3),
    /**
     * 自定义数据
     */
    CUSTOM(4);

    private final Integer value;

}
