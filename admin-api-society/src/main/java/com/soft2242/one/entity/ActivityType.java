package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 活动分类
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */

@Data
@TableName("t_activity_type")
public class ActivityType {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 活动名称
	 */
	private String name;

	/**
	 * 社区id（绑定所属社区）
	 */
	private Long communityId;

	/**
	 * 状态  0：正常 1：失效
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
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
		return "ActivityType{" +
				"id=" + id +
				", name=" + name +
				", communityId=" + communityId +
				", status=" + status +
				", deleted=" + deleted +
				", createTime=" + createTime +
				", creator=" + creator +
				", updater=" + updater +
				", updateTime=" + updateTime +
				"}";
	}
}