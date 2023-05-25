package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 用户查询
 *
 * @author mqxu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知查询")
public class NoticeQuery extends Query {
    @Schema(description = "公告id")
    private Long noticeId;

    @Schema(description = "通知标题")
    private String title;

    @Schema(description = "通知内容")
    private String content;



    @Schema(description = "所属小区")
    private Long communityId;
    @Schema(description = "发布人")
    private Long adminId;

}
