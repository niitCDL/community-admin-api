package com.soft2242.one.system.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 管理员部门关联表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "管理员部门关联表")
public class SysAdminDepartmentVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键")
	private Long ID;

	@Schema(description = "管理员ID")
	private Long adminId;

	@Schema(description = "管理员所属部门ID")
	private Long departmentId;

	@Schema(description = "删除标识 0：正常 1:删除")
	private Integer DELETED;

	@Schema(description = "创建人")
	private Long CREATOR;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "更新人")
	private Long UPDATER;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;


}