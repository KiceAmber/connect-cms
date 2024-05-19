package com.amber.dto.users;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersPageQueryDTO implements Serializable {
    private Integer page;
    private Integer size;
}
