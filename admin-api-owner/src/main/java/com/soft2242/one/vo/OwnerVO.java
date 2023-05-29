package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 业主表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Data
@Schema(description = "业主表")
public class OwnerVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "用户名")
	private String username;
	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "房产名称")
	private String houseName;
	@Schema(description = "所属小区")
	private String communityName;
	@Schema(description = "楼宇(楼名+单元名+房间号)")
	private String buildingName;
	@Schema(description = "姓名")
	private String realName;
	@Schema(description = "出生日期")
	private String birthday;
	@Schema(description = "民族")
	private String nation;
	@Schema(description = "婚姻状态")
	private Integer marriage;
	@Schema(description = "现住地址")
	private String address;
	@Schema(description = "性别(0:保密 1:男 2:女)")
	private Integer gender;

	@Schema(description = "手机号")
	private String phone;
	@Schema(description = "户籍所在地")
	private String domicileLocation;
	@Schema(description = "政治面貌")
	private String party;
	@Schema(description = "租住类型(0:长居 1:短住)")
	private Integer rentalType;
	@Schema(description = "身份证")
	private String identityCard;
	@Schema(description = "暂住证号")
	private String stayCard;
	@Schema(description = "紧急联系人信息(json)")
	private String eContacts;

	@Schema(description = "身份标识(0:业主 1:家属 2:租户)")
	private Integer identity;

	@Schema(description = "默认地址(0：否 1：是)")
	private Integer defaultAddress;

	@Schema(description = "状态(0:未审核1:已通过2:未通过)")
	private Integer state;

	@Schema(description = "删除标识(0:未删除 1:已删除)")
	private Integer deleted;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "更新者")
	private Long updater;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;


}