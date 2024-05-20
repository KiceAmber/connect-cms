package com.amber.service.impl;

import com.amber.dao.ResourcesDao;
import com.amber.dto.resources.CreateResourceDTO;
import com.amber.dto.resources.ResourcesPageQueryDTO;
import com.amber.entity.Resources;
import com.amber.result.PageResult;
import com.amber.service.ResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service("resourcesService")
public class ResourcesServiceImpl extends ServiceImpl<ResourcesDao, Resources> implements ResourcesService {

    @Resource
    private ResourcesDao resourcesDao;

    @Override
    public void createResource(CreateResourceDTO createResourceDTO) {
        Resources resources = Resources.builder()
                .name(createResourceDTO.getName())
                .description(createResourceDTO.getDescription())
                .path(createResourceDTO.getPath())
                .createTime(LocalDateTime.now())
                .build();
        resourcesDao.insertOneRecord(resources);
    }

    @Override
    public PageResult pageQuery(ResourcesPageQueryDTO resourcesPageQueryDTO) {
        PageHelper.startPage(resourcesPageQueryDTO.getPage(), resourcesPageQueryDTO.getSize());
        Page<Resources> page = resourcesDao.pageQuery(resourcesPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}

