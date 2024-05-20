package com.amber.service.impl;

import com.amber.dao.RoleResourcesDao;
import com.amber.dao.RolesDao;
import com.amber.dto.roles.CreateRoleDTO;
import com.amber.dto.roles.RolesPageQueryDTO;
import com.amber.entity.RoleResources;
import com.amber.entity.Roles;
import com.amber.result.PageResult;
import com.amber.service.RolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service("rolesService")
public class RolesServiceImpl extends ServiceImpl<RolesDao, Roles> implements RolesService {

    @Resource
    private RolesDao rolesDao;

    @Resource
    private RoleResourcesDao roleResourcesDao;

    @Override
    @Transactional
    public void createRole(CreateRoleDTO createRoleDTO) {
        // 添加 roles 表记录
        Roles roles = Roles.builder()
                .name(createRoleDTO.getName())
                .description(createRoleDTO.getDescription())
                .createTime(LocalDateTime.now())
                .build();
        rolesDao.insertOneRecord(roles);

        // 添加 roles_resources 表记录
        createRoleDTO.getResourceIdList().forEach(resourcesId -> {
            RoleResources roleResources = RoleResources.builder()
                    .roleId(roles.getId())
                    .resourceId(resourcesId)
                    .createTime(LocalDateTime.now())
                    .build();
            roleResourcesDao.insert(roleResources);
        });
    }

    @Override
    public PageResult pageQuery(RolesPageQueryDTO rolesPageQueryDTO) {
        PageHelper.startPage(rolesPageQueryDTO.getPage(), rolesPageQueryDTO.getSize());
        Page<Roles> page = rolesDao.pageQuery(rolesPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    @Transactional
    public void deleteRoleByIds(List<Integer> idList) {

        // 先删除 role 表的记录
        rolesDao.deleteRoleByIds(idList);

        // 删除 role_resources 表的记录
        roleResourcesDao.deleteRoleResourcesByRoleIdList(idList);
    }
}

