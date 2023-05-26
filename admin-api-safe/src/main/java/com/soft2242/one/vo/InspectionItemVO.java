package com.soft2242.one.vo;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;

/**
* 巡检项目
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "巡检项目")
public class InspectionItemVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "所属小区")
	private Long communityId;

	@Schema(description = "小区名称")
	private String communityName;

	@Schema(description = "巡检项目名称")
	private String name;

	@Schema(description = "规格型号")
		private String type;

	@Schema(description = "品牌厂商")
	private String factory;

	@Schema(description = "维保厂商")
	private String insuranceFactory;

	@Schema(description = "项目图片")
	private String photo;

	@Schema(description = "坐标")
	private String coordinate;

	@Schema(description = "备注")
	private String note;

	@Schema(description = "状态（0：启用，1：禁用）")
	private Integer status;
}