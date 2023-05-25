package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;




/**
* 巡检项目查询
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "巡检项目查询")
public class InspectionItemQuery extends Query {
//    @Schema(description = "所属小区")
//    private Long communityId;

    @Schema(description = "所属小区名")
    private String communityName;

    @Schema(description = "巡检项目名称")
    private String name;

}