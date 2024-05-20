package com.amber.dao;

import com.amber.entity.RoleResources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * (RoleResources)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
public interface RoleResourcesDao extends BaseMapper<RoleResources> {

    void deleteRoleResourcesByRoleIdList(List<Integer> idList);
}

