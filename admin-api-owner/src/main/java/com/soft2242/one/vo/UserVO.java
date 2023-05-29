package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 用户信息表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Data
@Schema(description = "用户信息表")
public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "用户昵称")
	private String username;

	@Schema(description = "性别(0:保密 1:男 2:女)")
	private Integer gender;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "手机号")
	private String phone;

	@Schema(description = "姓名")
	private String realName;

	@Schema(description = "生日")
	private String birthday;

	@Schema(description = "民族")
	private String nation;

	@Schema(description = "婚姻(0: 未婚 1:已婚)")
	private Integer marriage;

	@Schema(description = "户口(0:城市户口1:农村户口)")
	private Integer accountType;

	@Schema(description = "党派")
	private String party;

	@Schema(description = "户籍所在地")
	private String domicileLocation;

	@Schema(description = "租住类型(0:长居 1:短住)")
	private Integer rentalType;

	@Schema(description = "暂住证号")
	private String stayCard;

	@Schema(description = "住址")
	private String address;

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