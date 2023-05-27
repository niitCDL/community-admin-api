package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 小区和线路
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Data
@Schema(description = "小区中的线路")
public class ComAndPathVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "小区id")
    private Long communityId;
    @Schema(description = "小区名")
    private String communityName;

    @Schema(description = "线路列表")
    private List<PatrolPathVO> patrolPathVO;
}
