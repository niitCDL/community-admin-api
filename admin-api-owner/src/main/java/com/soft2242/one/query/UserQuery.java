package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
* 用户信息表查询
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户信息表查询")
public class UserQuery extends Query {
    @Schema(description = "自增主键")
    private Long id;

}