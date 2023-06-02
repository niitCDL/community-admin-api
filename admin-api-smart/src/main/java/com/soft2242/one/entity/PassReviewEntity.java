package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 门禁审核
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_pass_review")
public class PassReviewEntity extends BaseEntity {

	/**
	* 业主id
	*/
	private Long ownerId;

	/**
	* 房屋id
	*/
	private Long houseId;

	/**
	* 是否有人脸（0-无，1-有）
	*/
	private Integer face;

	/**
	* 是否有指纹（0-无，1-有）
	*/
	private Integer finger;

	/**
	* 审核状态（0-待审核，1-通过，2-驳回
	*/
	private Integer status;

}