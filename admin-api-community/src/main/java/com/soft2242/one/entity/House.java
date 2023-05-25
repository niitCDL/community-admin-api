package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 房屋表
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@TableName("t_house")
public class House implements Serializable {

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
     * 楼宇id
     */
    private Long buildingId;

    /**
     * 房间号
     */
    private String houseNumber;

    /**
     * 建筑面积
     */
    private Integer houseArea;

    /**
     * 房屋状态（0：未使用 1：使用中）
     */
    private Byte houseStatus;

    /**
     * 备注
     */
    private String content;

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

    private String communityName;

    private String buildingName;

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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Integer houseArea) {
        this.houseArea = houseArea;
    }

    public Byte getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Byte houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return "House{" +
            "id = " + id +
            ", communityId = " + communityId +
            ", buildingId = " + buildingId +
            ", houseNumber = " + houseNumber +
            ", houseArea = " + houseArea +
            ", houseStatus = " + houseStatus +
            ", content = " + content +
            ", deleted = " + deleted +
            ", creator = " + creator +
            ", createTime = " + createTime +
            ", updater = " + updater +
            ", updateTime = " + updateTime +
            ", communityName = " + communityName +
            ", buildingName = " + buildingName +
        "}";
    }
}
