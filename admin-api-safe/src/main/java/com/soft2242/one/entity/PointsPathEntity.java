package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * 巡更点巡更线路关联表实体类
 * @author litao
 * @since 1.0.0 2023-05-25
 */
@Data
@TableName("t_points_path")
public class PointsPathEntity extends BaseEntity {
    /**
     * 巡更线路id
     */
    private Long pathId;

    /**
     *巡更点id
     */
    private Long pointId;

    /**
     * 状态 0启用 1禁用
     */
    private Integer status;


}
