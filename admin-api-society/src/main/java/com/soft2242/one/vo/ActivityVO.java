package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
* 社区活动
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "社区活动")
public class ActivityVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "社区id")
	private Long communityId;

	@Schema(description = "物业表的，关联物业公司")
	private String property;

	@Schema(description = "排序")
	private Integer sort;

	@Schema(description = "活动名称")
	private String activityName;

	@Schema(description = "活动类别")
	private Long typeId;

	@Schema(description = "活动标题")
	private String title;

	@Schema(description = "活动内容（可为空）")
	private String content;

	@Schema(description = "活动地点")
	private String location;

	@Schema(description = "查看人数")
	private String viewerCount;

	@Schema(description = "电话")
	private String tel;

	@Schema(description = "状态  0：正常 1：失效")
	private Integer status;

	@Schema(description = "发布时间")
	private LocalDateTime publishTime;

	@Schema(description = "活动截至时间")
	private LocalDateTime endTime;

	@Schema(description = "删除标识 0：正常 1：已删除")
	private Integer deleted;

	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

	@Schema(description = "小区名字")
	private String communityName;
	@Schema(description = "活动类别")
	private String activityType;

}