package com.soft2242.one.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Schema(description = "用户详细信息")
public class SysUserInfoVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "adminId 管理员ID")
    private Long adminId;

    @Schema(description = "登录账号")
    private String userName;

    @Schema(description = "登录密码")
    private String password;

    @Schema(description = "是否是超管 1:是 0:不是")
    private Integer superAdmin;

    @Schema(description = "真实姓名")
    private String realName;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "职务ID")
    private Long postId;

    @Schema(description = "性别 0：保密   1：男   2：女", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer gender;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "微信账号")
    private String vxAccount;

    @Schema(description = "工号")
    private String jobNumber;

    @Schema(description = "籍贯")
    private String nativePlace;

    @Schema(description = "毕业院校")
    private String graduateSchool;

    @Schema(description = "毕业时间")
    private Date graduateTime;

    @Schema(description = "学历")
    private String education;

    @Schema(description = "专业")
    private String major;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "排序字段")
    private Integer sort;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;

    @Schema(description = "最后登录时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date lastLoginTime;


}
