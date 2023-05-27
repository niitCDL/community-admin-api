package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.util.Date;

/**
 * @ClassName CommunityVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/25 14:03
 */
@Data
@Schema(description = "社区")
public class CommunityVO {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "社区名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String communityName;

    @Schema(description = "社区地址", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;

    @Schema(description = "社区面积", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer coverArea;
    @Schema(description = "社区图片", requiredMode = Schema.RequiredMode.REQUIRED)
    private String communityImgs;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createTime;
    @Schema(description = "社区备注", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

}
