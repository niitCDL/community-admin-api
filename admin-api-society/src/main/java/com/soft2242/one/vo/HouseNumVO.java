package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Author: James
 * Date: 2023/5/28 12:02
 * Describe:
 */

@Data
@Schema(description = "房屋编号")
public class HouseNumVO {
    @Schema(description = "房屋号", requiredMode = Schema.RequiredMode.REQUIRED)
    private String houseNumber;
}
