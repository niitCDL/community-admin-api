package com.soft2242.one.system.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典数据
 *
 * @author mqxu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "字典数据查询")
public class SysDictDataQuery extends Query {
    @Schema(description = "字典类型ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "字典类型ID不能为空")
    private Long dictTypeId;

}
