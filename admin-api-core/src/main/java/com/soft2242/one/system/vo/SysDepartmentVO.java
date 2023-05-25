package com.soft2242.one.system.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.base.common.utils.TreeNode;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 部门
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "部门")
public class SysDepartmentVO extends TreeNode<SysDepartmentVO> {

	@Schema(description = "部门名称", requiredMode = Schema.RequiredMode.REQUIRED)
	@NotBlank(message = "部门名称不能为空")
	private String name;


	@Schema(description = "部门描述")
	private String remark;

	@Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
	@Min(value = 0, message = "排序值不能小于0")
	private Integer sort;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "上级名称")
	private String parentName;

}