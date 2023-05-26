package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 社区活动
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */

@Data
@TableName("t_activity")
public class Activity {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 社区id
	 */
	private Long communityId;

	/**
	 * 物业表的，关联物业公司
	 */
	private String property;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 活动名称
	 */
	private String activityName;

	/**
	 * 活动类别
	 */
	private Long typeId;

	/**
	 * 活动标题
	 */
	private String title;

	/**
	 * 活动内容（可为空）
	 */
	private String content;

	/**
	 * 活动地点
	 */
	private String location;

	/**
	 * 查看人数
	 */
	private String viewerCount;

	/**
	 * 电话
	 */
	private String tel;

	/**
	 * 状态  0：正常 1：失效
	 */
	private Integer status;

	/**
	 * 发布时间
	 */
	private LocalDateTime publishTime;

	/**
	 * 活动截至时间
	 */
	private LocalDateTime endTime;

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
	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String getViewerCount() {
		return viewerCount;
	}

	public void setViewerCount(String viewerCount) {
		this.viewerCount = viewerCount;
	}
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(LocalDateTime publishTime) {
		this.publishTime = publishTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
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
		return "Activity{" +
				"id=" + id +
				", communityId=" + communityId +
				", property=" + property +
				", sort=" + sort +
				", activityName=" + activityName +
				", typeId=" + typeId +
				", title=" + title +
				", content=" + content +
				", location=" + location +
				", viewerCount=" + viewerCount +
				", tel=" + tel +
				", status=" + status +
				", publishTime=" + publishTime +
				", endTime=" + endTime +
				", deleted=" + deleted +
				", createTime=" + createTime +
				", creator=" + creator +
				", updater=" + updater +
				", updateTime=" + updateTime +
				"}";
	}

}