package com.soft2242.one.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;


/**
 * 报修处理表
 *
 * @author xuelong
 * @since 1.0.0 2023-06-04
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_repair_record")
public class RepairRecordEntity extends BaseEntity {

	/**
	* 报修信息id
	*/
	private Long repairId;

	/**
	* 处理人id，逗号分隔
	*/
	private String employeeIds;

	/**
	* 处理状态（0：未处理，1：处理中，2：已完成）
	*/
	private Integer state;

	/**
	* 处理结果
	*/
	private String result;

	/**
	* 现场照片
	*/
	private String imgs;






}
