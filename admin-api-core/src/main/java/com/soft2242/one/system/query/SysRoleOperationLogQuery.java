package com.soft2242.one.system.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
* 角色操作记录表查询
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色操作记录表查询")
public class SysRoleOperationLogQuery extends Query {
}