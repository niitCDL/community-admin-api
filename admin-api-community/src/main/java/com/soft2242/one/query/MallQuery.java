package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName MallQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/28 19:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "商铺管理查询")
public class MallQuery extends Query {
    @Schema(description = "小区名称")
    private String communityName;
    @Schema(description = "业主名")
    private String realName;
    @Schema(description = "商铺编号")
    private String mallNumber;
}
