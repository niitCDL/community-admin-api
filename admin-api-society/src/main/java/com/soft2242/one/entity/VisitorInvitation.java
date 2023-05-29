package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_visitor_invitation")
public class VisitorInvitation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 访客表主键
     */
    private Long visitorId;

    /**
     * 绑定业主id
     */

    private Long userId;


    /**
     * 门禁表主键，关联访客允许访问入口，用”,” 分割（1，2，3，4）
     */
    private String doorIds;

    /**
     * 访问结束时间，判断是否可访问
     */
    private LocalDateTime endTime;

    /**
     * 状态（0：正常 1：禁用），判断是否可访问
     */
    private Integer status;

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

    private Long houseId;


}
