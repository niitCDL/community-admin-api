package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 投诉
*
* @author xuelong
* @since 1.0.0 2023-05-26
*/
@Data
@Schema(description = "投诉")
public class ComplaintVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "社区id")
	private Long communityId;
	private String communityName;
	@Schema(description = "投诉人id")
	private Long userId;
	private String userName;

	@Schema(description = "投诉类型(0:物业服务，1:社区服务)")
	private Integer type;

	@Schema(description = "投诉标题")
	private String title;

	@Schema(description = "投诉内容")
	private String content;

	@Schema(description = "图片")
	private String imgs;

	@Schema(description = "处理状态（0：未处理，1：处理中，2：已处理，3：已评价）")
	private Integer state;

	@Schema(description = "处理结果")
	private String result;

	@Schema(description = "处理人id，逗号分隔")
	private String[] employeeIds = null;

	private String[] employeeNames;
	@Schema(description = "处理时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date handleTime;

	@Schema(description = "评价内容")
	private String evaluate;

	@Schema(description = "评价时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date evaluateTime;

	@Schema(description = "删除标识（0：未删除 1：已删除）")
	private Integer deleted;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "更新者")
	private Long updater;


}
