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
public class NoticeReaderQuery extends Query {

    @Schema(description = "公告id")
    private String noticeId;
    @Schema(description = "阅读人")
    private String userId;

}
