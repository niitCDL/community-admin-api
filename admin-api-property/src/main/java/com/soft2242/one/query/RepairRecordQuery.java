package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
* 报修处理表查询
*
* @author xuelong
* @since 1.0.0 2023-06-04
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "报修处理表查询")
public class RepairRecordQuery extends Query {
}
