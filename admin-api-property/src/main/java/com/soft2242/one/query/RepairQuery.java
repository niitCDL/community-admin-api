package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* 报修表查询
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-26
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "报修表查询")
public class RepairQuery extends Query {
    @Schema(description = "社区id")
    private String[] communityId;

    @Schema(description = "报修标题")
    private String title;

    @Schema(description = "处理状态（0：未处理，1：处理中，2：已处理，3：已评价）")
    private String state;

    @Schema(description = "报修类型")
    private String type;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date[] createTime;

}
