package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* 巡更计划表查询
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "巡更计划表查询")
public class PatrolPlanQuery extends Query {
    @Schema(description = "小区名称")
    private String communityName;

    @Schema(description = "巡更计划名")
    private String planName;
}