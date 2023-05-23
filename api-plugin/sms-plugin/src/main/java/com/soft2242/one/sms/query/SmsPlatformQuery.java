package com.soft2242.one.sms.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信平台查询
 *
 * @author moqi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "短信平台查询")
public class SmsPlatformQuery extends Query {
    @Schema(description = "平台类型  0：阿里云   1：腾讯云")
    private Integer platform;

    @Schema(description = "短信签名")
    private String signName;

}