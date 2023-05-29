package com.soft2242.one.vo;

import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
* 停车场表
*
* @author Dr.King whfplus7@163.com
* @since 1.0.0 2023-05-29
*/
@Data
@Schema(description = "停车场")
public class ParkVO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "小区id")
	private Long communityId;
	@Schema(description = "小区名称", requiredMode = Schema.RequiredMode.REQUIRED)
	private String communityName;

	@Schema(description = "停车场名称")
	private String parkName;

	@Schema(description = "联系电话")
	private String contactPhone;

	@Schema(description = "地址")
	private String address;

	@Schema(description = "车位数量")
	private Integer carportNumber;

	@Schema(description = "状态（0：开启 1：关闭）")
	private Integer status;

	@Schema(description = "停车场图")
	private String parkImg;

	@Schema(description = "备注")
	private String content;

	@Schema(description = "单价（按小时收费）;10.00")
	private Double price;

	@Schema(description = "删除标识（0：未删除 1：已删除）")
	private Integer deleted;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "创建时间")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createTime;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;


}