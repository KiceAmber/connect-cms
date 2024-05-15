package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.ResourcesDao;
import com.amber.entity.Resources;
import com.amber.service.ResourcesService;
import org.springframework.stereotype.Service;

/**
 * (Resources)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("resourcesService")
public class ResourcesServiceImpl extends ServiceImpl<ResourcesDao, Resources> implements ResourcesService {

}

