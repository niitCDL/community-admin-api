package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * 巡检项目实体类
 * @author litao
 * @since 1.0.0 2023-05-25
 */
@Data
@TableName("t_inspection_item")
public class InspectionItemEntity extends BaseEntity {

    /**
     * 所属小区id
     */
    private Long communityId;


    /**
     * 巡检项目名称
     */
    private String name;

    /**
     * 设备类型
     */
    private String type;

    /**
     * 生产厂商
     */
    private String factory;

    /**
     * 维保厂商
     */
    private String insuranceFactory;

    /**
     * 巡检项目图片
     */
    private String photo;

    /**
     * 座标经纬度
     */
    private String coordinate;

    /**
     * 备注
     */
    private String note;

    /**
     *状态 0启用 1禁用
     */
    private Integer status;
}
