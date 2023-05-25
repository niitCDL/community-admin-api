package com.soft2242.one.system.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
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
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "删除标识（0:未删除 1:已删除）")
	private Integer deleted;

	@Schema(description = "创建人")
	private Long creator;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "更新人")
	private Long updater;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;

	@Schema(description = "操作")
	private Integer operate;

	@Schema(description = "原因")
	private String reason;


}