package com.soft2242.one.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;


import java.util.Date;

/**
 * 公告表
 * @TableName t_notice
 */
@TableName(value ="t_notice")
@Data
public class NoticeEntity extends BaseEntity {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 社区id
     */
    private Long communityId;

    /**
     * 发布人id
     */
    private Long adminId;

    /**
     * 通知类型(0:消杀通知 1：物业通知 2：缴费通知)
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 附件
     */
    private String file;

    /**
     * 阅读数
     */
    private Integer readNumber;

    /**
     * 提醒方式（0：系统消息 1：短信通知）
     */
    private Integer noticeWay;

    /**
     * 接受范围(0:全部楼宇，1：指定楼宇)
     */
    private Integer noticeRange;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 审核(0:未审核，1：已审核，2:审核不通过)
     */
    private Integer review;

    /**
     * 审核人id
     */
    private Long reviewUserId;

    /**
     * 审核时间
     */
    private Date reviewTime;

}
