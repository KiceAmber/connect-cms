package com.amber.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long authorId;

    private Long communityId;

    private String title;

    private String cover;

    private String content;

    private Integer likeCount;

    private Integer commentCount;

    private Integer Heat;

    private Integer ViewCount;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
