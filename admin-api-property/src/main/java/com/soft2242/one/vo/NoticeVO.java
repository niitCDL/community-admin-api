package com.soft2242.one.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;


import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 公告表
 *
 * @TableName t_notice
 */
@Data
@Schema(description = "公告")
public class NoticeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "社区id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "社区id不能为空")
    private Long communityId;

    @Schema(description = "发布人id", requiredMode = Schema.RequiredMode.REQUIRED)
//    @NotNull(message = "发布人id不能为空")
    private Long adminId;


    @Schema(description = "通知类型(0:消杀通知 1：物业通知 2：缴费通知)", requiredMode = Schema.RequiredMode.REQUIRED)
    @Range(min = 0, max = 2, message = "用户状态不正确")
    private Integer type;

    @Schema(description = "公告标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "公告标题不能为空")
    private String title;

    @Schema(description = "公告内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "公告内容不能为空")
    private String content;

    @Schema(description = "附件")
    private String file;

    @Schema(description = "阅读数人数")
    private Integer readNumber;

    @Schema(description = "提醒方式（0：系统消息 1：短信通知）")
    @Range(min = 0, max = 1, message = "提醒方式不正确")
    private Integer noticeWay;

    @Schema(description = "审核(0:未审核，1：已审核，2:审核不通过)", requiredMode = Schema.RequiredMode.REQUIRED)
    @Range(min = 0, max = 2, message = "接受范围不正确")
    private Integer noticeRange;
    @Schema(description = "发布时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date publishTime;

    @Schema(description = "通知类型(0:消杀通知 1：物业通知 2：缴费通知)", requiredMode = Schema.RequiredMode.REQUIRED)
    @Range(min = 0, max = 2, message = "用户状态不正确")
    private Integer review;


    @Schema(description = "审核人id", requiredMode = Schema.RequiredMode.REQUIRED)
//    @NotNull(message = "审核人id不能为空")
    private Long reviewUerId;
    @Schema(description = "审核时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date reviewTime;






}
