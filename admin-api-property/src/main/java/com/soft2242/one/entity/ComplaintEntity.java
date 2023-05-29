package com.soft2242.one.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 投诉
 *
 * @author xuelong
 * @since 1.0.0 2023-05-26
 */

@Data
@TableName("t_complaint")
public class ComplaintEntity  extends BaseEntity {
	/**
	* id
	*/
	@TableId
	private Long id;

	/**
	* 社区id
	*/
	private Long communityId;

	/**
	* 投诉人id
	*/
	private Long userId;

	/**
	* 投诉类型(0:物业服务，1:社区服务)
	*/
	private Integer type;

	/**
	* 投诉标题
	*/
	private String title;

	/**
	* 投诉内容
	*/
	private String content;

	/**
	* 图片
	*/
	private String imgs;

	/**
	* 处理状态（0：未处理，1：处理中，2：已处理，3：已评价）
	*/
	private Integer state;

	/**
	* 处理结果
	*/
	private String result;

	/**
	* 处理人id，逗号分隔
	*/
	private String employeeIds;

	/**
	* 处理时间
	*/
	private Date handleTime;

	/**
	* 评价内容
	*/
	private String evaluate;

	/**
	* 评价时间
	*/
	private Date evaluateTime;


}
