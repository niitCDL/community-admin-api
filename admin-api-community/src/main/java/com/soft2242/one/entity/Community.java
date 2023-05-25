package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 社区表
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_community")
public class Community implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 社区名称
     */
    private String communityName;

    /**
     * 所在地区
     */
    private String address;

    /**
     * 占地面积
     */
    private Integer coverArea;

    /**
     * 社区图片（英文逗号分割）
     */
    private String communityImgs;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(Integer coverArea) {
        this.coverArea = coverArea;
    }

    public String getCommunityImgs() {
        return communityImgs;
    }

    public void setCommunityImgs(String communityImgs) {
        this.communityImgs = communityImgs;
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

    @Override
    public String toString() {
        return "Community{" +
            "id = " + id +
            ", communityName = " + communityName +
            ", address = " + address +
            ", coverArea = " + coverArea +
            ", communityImgs = " + communityImgs +
            ", content = " + content +
            ", deleted = " + deleted +
            ", creator = " + creator +
            ", createTime = " + createTime +
            ", updater = " + updater +
            ", updateTime = " + updateTime +
        "}";
    }
}
