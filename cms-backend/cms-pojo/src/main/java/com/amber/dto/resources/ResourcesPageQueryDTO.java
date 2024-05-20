package com.amber.dto.resources;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourcesPageQueryDTO implements Serializable {
    private Integer page;
    private Integer size;
}
