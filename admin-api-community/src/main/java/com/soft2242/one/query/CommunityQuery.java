package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName CommunityQuery
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/25 14:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "社区管理查询")
public class CommunityQuery extends Query {
    @Schema(description = "社区ID")
    private Long id;
    @Schema(description = "社区名称")
    private String communityName;
}
