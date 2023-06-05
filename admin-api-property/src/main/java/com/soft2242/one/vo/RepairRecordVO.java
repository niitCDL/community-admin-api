package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 报修处理表
*
* @author xuelong
* @since 1.0.0 2023-06-04
*/
@Data
@Schema(description = "报修处理表")
public class RepairRecordVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "报修信息id")
	private Long repairId;

	@Schema(description = "处理人id，逗号分隔")
	private String employeeIds;

	@Schema(description = "处理状态（0：未处理，1：处理中，2：已完成）")
	private Integer state;

	@Schema(description = "处理结果")
	private String result;

	@Schema(description = "现场照片")
	private String imgs;

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
