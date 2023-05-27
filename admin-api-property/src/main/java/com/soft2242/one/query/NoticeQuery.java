package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


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
    private String noticeId;

    @Schema(description = "通知标题")
    private String title;

    @Schema(description = "通知内容")
    private String content;



    @Schema(description = "所属小区")
    private String[] communityId;
    @Schema(description = "发布人")
    private String adminId;
    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date[] createTime;

}
