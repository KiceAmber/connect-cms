package com.amber.dto.tags;

import lombok.Data;

import java.io.Serializable;

@Data
public class TagsPageQueryDTO implements Serializable {

    private Integer page;
    private Integer size;
}
