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
@TableName("t_visitor_invitation")
public class VisitorInvitation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 访客表主键
     */
    private Integer visitorId;

    /**
     * 绑定业主id
     */

    private Integer userId;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }
    public Integer getOwnerId() {

        return userId;
    }

    public void setOwnerId(Integer userId) {
        this.userId = userId;

    }
    public String getDoorIds() {
        return doorIds;
    }

    public void setDoorIds(String doorIds) {
        this.doorIds = doorIds;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }
    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "VisitorInvitation{" +
            "id=" + id +
            ", visitorId=" + visitorId +
            ", userId=" + userId +
            ", doorIds=" + doorIds +
            ", endTime=" + endTime +
            ", status=" + status +
            ", deleted=" + deleted +
            ", createTime=" + createTime +
            ", creator=" + creator +
            ", updater=" + updater +
            ", updateTime=" + updateTime +
        "}";
    }
}
