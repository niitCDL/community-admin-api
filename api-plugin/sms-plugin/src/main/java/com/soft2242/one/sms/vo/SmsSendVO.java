package com.soft2242.one.sms.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 短信发送
 *
 * @author moqi
 */
@Data
@Schema(description = "短信发送")
public class SmsSendVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "参数Key")
    private String paramKey;

    @Schema(description = "参数Value")
    private String paramValue;

}