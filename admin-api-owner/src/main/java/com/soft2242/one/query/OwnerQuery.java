package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
* 业主表查询
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "业主表查询")
public class OwnerQuery extends Query {
    @Schema(description = "小区名")
    private String communityName;
    @Schema(description = "起始条数")
    private Integer start;
    @NotNull(message = "状态不能为空")
    @Schema(description = "状态")
    private Integer state;

}