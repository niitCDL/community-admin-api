package com.soft2242.one.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Schema(description = "用户角色解绑")
public class SysUnbindingUserRoleVO implements Serializable {
    @Schema(description = "角色Id")
    private Long roleId;
    @Schema(description = "用户Id集合")
    private List<Long> adminIdList;
}
