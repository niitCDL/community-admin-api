package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
* 门禁管理
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@Schema(description = "门禁管理")
public class DoorReviewVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "门禁名称")
	private String doorName;

	@Schema(description = "所属小区")
	private Long communityId;

	@Schema(description = "所属小区")
	private String communityName;

	@Schema(description = "允许欠费通行 0-允许 1-不允许")
	private Integer allowOwed;

	@Schema(description = "允许访客通行  0-允许 1-不允许")
	private Integer allowVisit;

	@Schema(description = "需要访客手机号 0-需要 1-不需要")
	private Integer needTel;

	@Schema(description = "需要访客身份证 0-需要 1-不需要")
	private Integer needIdCard;

	@Schema(description = "允许人脸识别 0-允许 1-不允许")
	private Integer allowFace;

	@Schema(description = "允许指纹识别  0-允许 1-不允许")
	private Integer allowFinger;
}