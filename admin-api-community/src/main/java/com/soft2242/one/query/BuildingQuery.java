package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName BuildingQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/26 08:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "楼宇管理查询")
public class BuildingQuery extends Query {
    @Schema(description = "小区名称")
    private String communityName;
    @Schema(description = "楼宇名称")
    private String buildingName;
    @Schema(description = "所在单元")
    private String units;
}
