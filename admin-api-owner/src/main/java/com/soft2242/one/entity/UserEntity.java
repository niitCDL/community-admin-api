package com.soft2242.one.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author lsc lsc666@qq.com
 * @since 1.0.0 2023-05-28
 */

@Data
@TableName("t_user")
public class UserEntity {
	/**
	* 自增主键
	*/
	@TableId
	private Long id;

	/**
	* 用户昵称
	*/
	private String username;

	/**
	* 性别(0:保密 1:男 2:女)
	*/
	private Integer gender;

	/**
	* 头像
	*/
	private String avatar;

	/**
	* 手机号
	*/
	private String phone;

	/**
	* 姓名
	*/
	private String realName;

	/**
	* 生日
	*/
	private String birthday;

	/**
	* 民族
	*/
	private String nation;

	/**
	* 婚姻(0: 未婚 1:已婚)
	*/
	private Integer marriage;

	/**
	* 户口(0:城市户口1:农村户口)
	*/
	private Integer accountType;

	/**
	* 党派
	*/
	private String party;

	/**
	* 户籍所在地
	*/
	private String domicileLocation;

	/**
	* 租住类型(0:长居 1:短住)
	*/
	private Integer rentalType;

	/**
	* 暂住证号
	*/
	private String stayCard;

	/**
	* 住址
	*/
	private String address;

	/**
	* 删除标识(0:未删除 1:已删除)
	*/
	private Integer deleted;

	/**
	* 创建者
	*/
	private Long creator;

	/**
	* 创建时间
	*/
	private Date createTime;

	/**
	* 更新者
	*/
	private Long updater;

	/**
	* 更新时间
	*/
	private Date updateTime;

}