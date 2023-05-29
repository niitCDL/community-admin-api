package com.soft2242.one.system.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
* 角色操作记录表
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "角色操作记录表")
public class SysRoleOperationLogVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@MyExcelProperty("ID")
	@Schema(description = "id")
	private Long id;


	@Schema(description = "删除标识（0:未删除 1:已删除）")
	private Integer deleted;

	@MyExcelProperty("操作人")
	@Schema(description = "创建人")
	private Long creator;

	@MyExcelProperty("创建时间")
	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@MyExcelProperty("更新人")
	@Schema(description = "更新人")
	private Long updater;

	@MyExcelProperty("更新时间")
	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;

	@MyExcelProperty("操作")
	@Schema(description = "操作")
	private String operate;

	@MyExcelProperty("操作对象ID")
	@Schema(description = "操作对象ID")
	private Long operationObject;

	@MyExcelProperty("操作对象名称")
	@Schema(description = "操作对象名称")
	private String operationObjectName;

	@MyExcelProperty("操作者名称")
	@Schema(description = "操作者名称")
	private String operatorName;

	@MyExcelProperty("修改者名称")
	@Schema(description = "修改者名称")
	private String updaterName;

	@MyExcelProperty("原因")
	@Schema(description = "原因")
	private String reason;
}