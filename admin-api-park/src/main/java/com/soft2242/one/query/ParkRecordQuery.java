package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName ParkRecordQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 08:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "停车记录查询")
public class ParkRecordQuery extends Query {
    @Schema(description = "停车场名称")
    private String parkName;
    @Schema(description = "车牌号")
    private String licence;
    @Schema(description = "设备名")
    private String doorName;
    @Schema(description = "车辆类型（0：临时车辆 1：固定车辆）")
    private Integer type;
}
