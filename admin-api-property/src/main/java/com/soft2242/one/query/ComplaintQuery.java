package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* 投诉查询
*
* @author xuelong
* @since 1.0.0 2023-05-26
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "投诉查询")
public class ComplaintQuery extends Query {
    @Schema(description = "社区id")
    private String[] communityId;

    @Schema(description = "投诉类型(0:物业服务，1:社区服务)")
    private String type;

    @Schema(description = "处理状态（0：未处理，1：处理中，2：已处理，3：已评价）")
    private String state;

//    @Schema(description = "更新时间")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private Date[] updateTime;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date[] createTime;

}
