package com.soft2242.one.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 图片验证码
 *
 * @author moqi
 */
@Data
@Schema(description = "图片验证码")
public class SysCaptchaVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "key")
    private String key;

    @Schema(description = "image base64")
    private String image;
}
