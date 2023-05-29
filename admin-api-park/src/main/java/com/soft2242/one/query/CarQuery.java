package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName CarQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "车辆表查询")
public class CarQuery extends Query {
    @Schema(description = "车牌号")
    private String licence;
    @Schema(description = "用户名字")
    private String realName;
    @Schema(description = "车辆品牌")
    private String brand;
}
