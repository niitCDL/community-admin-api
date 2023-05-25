package com.soft2242.one.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serial;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 22:28
 */
@Data
@Schema(description = "公告阅读记录")
public class NoticeReaderVO {
    @Serial
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long id;

    @Schema(description = "公告id")
    private Long noticeId;

    @Schema(description = "阅读人id")
    private Long userId;
}



