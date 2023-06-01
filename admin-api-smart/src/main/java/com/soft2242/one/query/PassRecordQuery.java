package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 通行记录查询
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通行记录查询")
public class PassRecordQuery extends Query {
    @Schema(description = "业主")
    private String username;

    @Schema(description = "闸机id")
    private Long doorId;

    @Schema(description = "出入方式 0-刷卡 1-人脸 2-指纹")
    private Integer passWay;

    @Schema(description = "小区id")
    private Long communityId;

}