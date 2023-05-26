package com.soft2242.one.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 巡更路线表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */

@Data
@TableName("t_patrol_path")
public class  PatrolPathEntity  extends BaseEntity {
	/**
	* 自增主键
	*/
	@TableId
	private Long id;

	/**
	* 所属小区
	*/
	private Long communityId;

	/**
	* 巡更路线名
	*/
	private String wayName;

	/**
	* 定位距离(不能离开指定位置多少米)
	*/
	private BigDecimal locationLength;

	/**
	* 状态（0：正常，1：禁用）
	*/
	private Integer status;

	/**
	* 线路类型(0：巡更点类型，1：巡检项目类型)
	*/
	private Integer type;

	/**
	* 删除标识（0：未删除，1：已删除）
	*/


}