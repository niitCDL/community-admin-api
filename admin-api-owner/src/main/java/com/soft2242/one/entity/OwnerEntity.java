package com.soft2242.one.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.*;

/**
 * 业主表
 *
 * @author lsc lsc666@qq.com
 * @since 1.0.0 2023-05-28
 */

@Data
@TableName("t_owner")
public class OwnerEntity extends BaseEntity {
	/**
	* 自增主键
	*/
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	* 用户唯一标识
	*/
	private Long userId;

	/**
	* 房屋id
	*/
	private Long houseId;

	/**
	* 绑定业主id
	*/
	private Long ownerId;

	/**
	* 姓名
	*/
	private String realName;

	/**
	* 性别(0:保密 1:男 2:女)
	*/
	private Integer gender;

	/**
	* 手机号
	*/
	private String phone;

	/**
	* 身份证
	*/
	private String identityCard;

	/**
	* 紧急联系人信息(json)
	*/
	private String eContacts;

	/**
	* 身份标识(0:业主 1:家属 2:租户)
	*/
	private Integer identity;

	/**
	* 默认地址(0：否 1：是)
	*/
	private Integer defaultAddress;

	/**
	* 状态(0:未审核1:已通过2:未通过)
	*/
	private Integer state;
	/**
	 * 是否注册
	 */
	private String isRegister;

}