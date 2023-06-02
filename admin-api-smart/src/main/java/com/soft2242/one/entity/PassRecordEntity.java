package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通行记录
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_pass_record")
public class PassRecordEntity extends BaseEntity {

	/**
	* 业主id
	*/
	private Long userId;

	/**
	* 闸机id
	*/
	private Long doorId;

	/**
	* 出入方式 0-刷卡 1-人脸 2-指纹 3-物业开门
	*/
	private Integer passWay;

	/**
	* 小区id
	*/
	private Long communityId;

}