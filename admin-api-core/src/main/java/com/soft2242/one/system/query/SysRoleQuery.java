package com.soft2242.one.system.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月24日 15:00
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysRoleQuery extends Query {

    @Schema(description = "角色名称")
    private String name;

}
