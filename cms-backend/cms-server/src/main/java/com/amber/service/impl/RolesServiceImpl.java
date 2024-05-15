package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.RolesDao;
import com.amber.entity.Roles;
import com.amber.service.RolesService;
import org.springframework.stereotype.Service;

/**
 * (Roles)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Service("rolesService")
public class RolesServiceImpl extends ServiceImpl<RolesDao, Roles> implements RolesService {

}

