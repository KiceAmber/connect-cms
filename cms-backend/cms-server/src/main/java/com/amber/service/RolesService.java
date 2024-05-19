package com.amber.service;

import com.amber.dto.roles.CreateRoleDTO;
import com.amber.dto.roles.RolesPageQueryDTO;
import com.amber.entity.Roles;
import com.amber.result.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RolesService extends IService<Roles> {

    void createRole(CreateRoleDTO createRoleDTO);

    PageResult pageQuery(RolesPageQueryDTO rolesPageQueryDTO);
}

