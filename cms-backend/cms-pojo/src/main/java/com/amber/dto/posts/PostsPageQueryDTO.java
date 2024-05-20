package com.amber.dto.posts;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostsPageQueryDTO implements Serializable {

    private Integer page;
    private Integer size;
}
