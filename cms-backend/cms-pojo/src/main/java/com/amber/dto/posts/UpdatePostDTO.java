package com.amber.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostDTO implements Serializable {
    private Integer id;
    private Integer type;
    private String title;
    private String content;
    private String cover;
    private String url;
    private String summary;
    private Integer userId;
    private Integer categoryId;
    private List<Integer> tagIdList;
    private Integer commentCount;
    private Integer viewCount;
    private Integer isTop;
    private String slug;
    private Integer status;
}
