package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


/**
* 社区活动查询
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "社区活动查询")
public class ActivityQuery extends Query {
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "活动截至时间")
    private LocalDateTime endTime;

    @Schema(description = "活动名称")
    private String activityName;

}