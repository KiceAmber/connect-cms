package com.amber.dto.roles;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolesPageQueryDTO implements Serializable {

    private Integer page;
    private Integer size;
}
