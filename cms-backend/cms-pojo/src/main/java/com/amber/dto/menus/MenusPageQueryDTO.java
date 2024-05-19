package com.amber.dto.menus;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenusPageQueryDTO implements Serializable {

    private Integer page;
    private Integer size;
}
