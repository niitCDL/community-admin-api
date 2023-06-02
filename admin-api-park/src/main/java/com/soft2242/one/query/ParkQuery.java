package com.soft2242.one.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.soft2242.one.base.common.query.Query;

/**
* 停车场表查询
*
* @author Dr.King whfplus7@163.com
* @since 1.0.0 2023-05-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "停车场表查询")
public class ParkQuery extends Query {
    @Schema(description = "停车场名称")
    private String parkName;
    @Schema(description = "小区名称")
    private String communityName;

}