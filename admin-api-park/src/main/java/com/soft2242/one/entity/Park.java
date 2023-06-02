package com.soft2242.one.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 停车场表
 *
 * @author Dr.King whfplus7@163.com
 * @since 1.0.0 2023-05-29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_park")
public class Park {
	/**
	* 自增主键
	*/
	@TableId
	private Long id;

	/**
	* 社区id
	*/
	private Long communityId;

	/**
	* 停车场名称
	*/
	private String parkName;

	/**
	* 联系电话
	*/
	private String contactPhone;

	/**
	* 地址
	*/
	private String address;

	/**
	* 车位数量
	*/
	private Integer carportNumber;

	/**
	* 状态（0：开启 1：关闭）
	*/
	private Integer status;

	/**
	* 停车场图
	*/
	private String parkImg;

	/**
	* 备注
	*/
	private String content;

	/**
	* 单价（按小时收费）;10.00
	*/
	private Double price;

	/**
	* 删除标识（0：未删除 1：已删除）
	*/
	private Integer deleted;

	/**
	* 创建者
	*/
	private Long creator;

	/**
	* 创建时间
	*/
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	* 更新者
	*/
	private Long updater;

	/**
	* 更新时间
	*/
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}