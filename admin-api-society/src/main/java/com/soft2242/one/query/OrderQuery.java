package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: James
 * Date: 2023/5/25 19:16
 * Describe:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "订单查询")
public class OrderQuery extends Query {

}
