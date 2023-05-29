package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
* 门禁审核
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@Schema(description = "门禁审核")
public class PassReviewVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "业主id")
	private Long ownerId;

	@Schema(description = "业主名")
	private String ownerName;

	@Schema(description = "房屋id")
	private Long houseId;

	@Schema(description = "房屋id")
	private String houseNumber;

	@Schema(description = "小区名")
	private String communityName;

	@Schema(description = "是否有人脸（0-无，1-有）")
	private Integer face;

	@Schema(description = "是否有指纹（0-无，1-有）")
	private Integer finger;

	@Schema(description = "审核状态（0-待审核，1-通过，2-驳回）")
	private Integer status;
}