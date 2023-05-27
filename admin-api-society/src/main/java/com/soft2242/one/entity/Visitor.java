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
    private Integer id;

    /**
     * 绑定业主id
     */
    private Integer ownerId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDoorIds() {
        return doorIds;
    }

    public void setDoorIds(String doorIds) {
        this.doorIds = doorIds;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public LocalDateTime getCreateTime1() {

        return createTime;
    }

    public void setCreateTime1(LocalDateTime createTime1) {
        this.createTime = createTime1;

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
    public LocalDateTime getUpdateTime1() {

        return updateTime;
    }

    public void setUpdateTime1(LocalDateTime updateTime1) {
        this.updateTime = updateTime1;

    }

    @Override
    public String toString() {
        return "Visitor{" +
            "id=" + id +
            ", ownerId=" + ownerId +
            ", name=" + name +
            ", phone=" + phone +
            ", doorIds=" + doorIds +
            ", status=" + status +
            ", count=" + count +
            ", deleted=" + deleted +
            ", createTime1=" + createTime +
            ", creator=" + creator +
            ", updater=" + updater +
            ", updateTime1=" + updateTime +
        "}";
    }
}
