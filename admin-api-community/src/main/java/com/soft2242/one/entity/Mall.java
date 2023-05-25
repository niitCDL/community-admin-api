package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商铺表
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@TableName("t_mall")
public class Mall implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 社区id
     */
    private Long communityId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商铺编号
     */
    private String mallNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 建筑面积
     */
    private Integer mallArea;

    /**
     * 商铺类型
     */
    private String mallType;

    /**
     * 商铺状态(0：未售出 1：已售出)
     */
    private Byte mallStatus;

    /**
     * 删除标识（0：未删除 1：已删除）
     */
    private Byte deleted;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private Long updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMallNumber() {
        return mallNumber;
    }

    public void setMallNumber(String mallNumber) {
        this.mallNumber = mallNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMallArea() {
        return mallArea;
    }

    public void setMallArea(Integer mallArea) {
        this.mallArea = mallArea;
    }

    public String getMallType() {
        return mallType;
    }

    public void setMallType(String mallType) {
        this.mallType = mallType;
    }

    public Byte getMallStatus() {
        return mallStatus;
    }

    public void setMallStatus(Byte mallStatus) {
        this.mallStatus = mallStatus;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
        return "Mall{" +
            "id = " + id +
            ", communityId = " + communityId +
            ", userId = " + userId +
            ", mallNumber = " + mallNumber +
            ", address = " + address +
            ", mallArea = " + mallArea +
            ", mallType = " + mallType +
            ", mallStatus = " + mallStatus +
            ", deleted = " + deleted +
            ", creator = " + creator +
            ", createTime = " + createTime +
            ", updater = " + updater +
            ", updateTime = " + updateTime +
        "}";
    }
}
