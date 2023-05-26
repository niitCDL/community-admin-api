package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: James
 * Date: 2023/5/25 19:57
 * Describe:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "访客开门记录查询")
public class VisitorInvitationQuery extends Query {
}
