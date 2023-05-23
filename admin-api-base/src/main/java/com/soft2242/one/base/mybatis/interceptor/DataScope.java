package com.soft2242.one.base.mybatis.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据范围
 *
 * @author moqi
 */
@Data
@AllArgsConstructor
public class DataScope {
    private String sqlFilter;

}