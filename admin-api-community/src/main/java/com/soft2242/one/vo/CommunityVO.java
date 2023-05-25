package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
    //@NotBlank(message = "社区名称不能为空")
    private String communityName;

    @Schema(description = "社区地址", requiredMode = Schema.RequiredMode.REQUIRED)
    //@NotBlank(message = "社区地址不能为空")
    private String address;

    @Schema(description = "社区面积", requiredMode = Schema.RequiredMode.REQUIRED)
    //@NotBlank(message = "社区地址不能为空")
    private Integer coverArea;
    @Schema(description = "社区图片", requiredMode = Schema.RequiredMode.REQUIRED)
    //@NotBlank(message = "社区地址不能为空")
    private String communityImgs;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    //@NotBlank(message = "社区地址不能为空")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Schema(description = "社区备注", requiredMode = Schema.RequiredMode.REQUIRED)
    //@NotBlank(message = "社区地址不能为空")
    private String content;

}
