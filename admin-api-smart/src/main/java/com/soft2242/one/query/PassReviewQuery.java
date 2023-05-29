package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 门禁审核查询
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "门禁审核查询")
public class PassReviewQuery extends Query {
    @Schema(description = "业主id")
    private String ownerName;

    @Schema(description = "小区")
    private Long communityId;

    @Schema(description = "审核状态（0-待审核，1-通过，2-驳回")
    private Integer status;

}