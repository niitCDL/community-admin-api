package com.soft2242.one.constant;

/**
 * @ClassName: OwnerConstant
 * @Author: lsc
 * @Date: 2023/05/30/21:24
 */
public interface OwnerConstant {
    /**
     * 未注册
     */
    String UNREGISTERED ="未注册";
    /**
     * 已注册
     */
    String REGISTERED ="已注册";
    /**
     * 去重sql
     */
    String DEDUPLICATION_SQL = "DISTINCT identity_card,real_name,id";
}
