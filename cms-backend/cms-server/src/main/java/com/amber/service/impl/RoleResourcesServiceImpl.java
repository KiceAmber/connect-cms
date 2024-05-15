package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.RoleResourcesDao;
import com.amber.entity.RoleResources;
import com.amber.service.RoleResourcesService;
import org.springframework.stereotype.Service;

/**
 * (RoleResources)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Service("roleResourcesService")
public class RoleResourcesServiceImpl extends ServiceImpl<RoleResourcesDao, RoleResources> implements RoleResourcesService {

}

