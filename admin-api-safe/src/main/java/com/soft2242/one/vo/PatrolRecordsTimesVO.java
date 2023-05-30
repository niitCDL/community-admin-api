package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author huang
 * @Description
 * @Date 2023 05 26 16 17
 **/
@Data
@Schema(description = "巡更记录表")
public class PatrolRecordsTimesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "自增主键")
    private Long id;

    @Schema(description = "巡更计划id")
    private Long planId;

    @Schema(description = "巡更路线id")
    private Long pathId;
}
