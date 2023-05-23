package com.soft2242.one.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Schema(description = "用户登录Token")
public class SysTokenVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "accessToken")
    private String accessToken;
}