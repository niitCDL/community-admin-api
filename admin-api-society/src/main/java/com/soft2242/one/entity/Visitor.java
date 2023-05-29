package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
@Data
@TableName("t_visitor")
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 绑定业主id
     */
    private Long ownerId;

    /**
     * 访客姓名
     */
    private String name;

    /**
     * 授权人手机号
     */
    private String phone;

    /**
     * 门禁表主键，关联访客允许访问入口，用”,” 分割（1，2，3，4）
     */
    private String doorIds;

    /**
     * 访问状态（0：已经访问1：未访问）
     */
    private Integer status;

    /**
     * 访问次数
     */
    private Integer count;

    /**
     * 删除标识 0：正常 1：已删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */

    private LocalDateTime createTime;


    /**
     * 创建者
     */
    private Long creator;

    /**
     * 更新者
     */
    private Long updater;

    /**
     * 更新时间
     */

    private LocalDateTime updateTime;

}
