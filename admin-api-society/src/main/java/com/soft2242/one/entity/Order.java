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
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户表主键
     */
    private Long userId;

    /**
     * 社区表
     */
    private Long comminityId;

    /**
     * 账单表主键
     */
    private Long billId;

    /**
     * 停车记录表id
     */
    private Long parkRecordId;

    /**
     * 订单类型 0：购买车位订单1：租赁车位订单2：停车订单3：水费4：电费5：物业费
     */
    private Integer orderType;

    /**
     * 订单单价
     */
    private String price;

    /**
     * 订单消费量，税费电费，物业费
     */
    private Double amount;

    /**
     * 收费金额
     */
    private Double money;

    /**
     * 订单状态（0：未完成 1：已完成）
     */
    private Integer status;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

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

    /**
     * 房屋表主键
     */
    private Long houseId;

    /**
     * 业主表主键
     */
    private Long ownerId;

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getComminityId() {
        return comminityId;
    }

    public void setComminityId(Long comminityId) {
        this.comminityId = comminityId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getParkRecordId() {
        return parkRecordId;
    }

    public void setParkRecordId(Long parkRecordId) {
        this.parkRecordId = parkRecordId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
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
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", comminityId=" + comminityId +
                ", billId=" + billId +
                ", parkRecordId=" + parkRecordId +
                ", orderType=" + orderType +
                ", price=" + price +
                ", amount=" + amount +
                ", money=" + money +
                ", status=" + status +
                ", payTime=" + payTime +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", creator=" + creator +
                ", updater=" + updater +
                ", updateTime=" + updateTime +
                "}";
    }
}
