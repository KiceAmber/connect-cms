package com.amber.dao;

import com.amber.dto.roles.RolesPageQueryDTO;
import com.amber.entity.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;

import java.util.List;

public interface RolesDao extends BaseMapper<Roles> {

    void insertOneRecord(Roles roles);

    Page<Roles> pageQuery(RolesPageQueryDTO rolesPageQueryDTO);

    void deleteRoleByIds(List<Integer> idList);
}

