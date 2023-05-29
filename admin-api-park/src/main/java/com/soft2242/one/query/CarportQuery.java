package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName CarportQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "车位表查询")
public class CarportQuery extends Query {

    @Schema(description = "车牌号")
    private String licence;
    @Schema(description = "业主名字")
    private String realName;
    @Schema(description = "停车场名称")
    private String parkName;
    @Schema(description = "车位名称")
    private String carportName;
}
