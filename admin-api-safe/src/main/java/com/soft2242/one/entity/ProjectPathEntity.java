package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * 巡检项目线路关联表实体类
 * @author litao
 */
@Data
@TableName("t_project_path")
public class ProjectPathEntity extends BaseEntity {

    /**
     * 巡检项目id
     */
    private Long itemId;

    /**
     * 巡检线路id
     */
    private Long pathId;

    /**
     * 状态 0启用 1禁用
     */
    private Integer status;

}
