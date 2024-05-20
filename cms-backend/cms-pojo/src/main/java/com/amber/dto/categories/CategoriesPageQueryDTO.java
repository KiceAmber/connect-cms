package com.amber.dto.categories;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriesPageQueryDTO implements Serializable {

    private Integer page;
    private Integer size;
}
