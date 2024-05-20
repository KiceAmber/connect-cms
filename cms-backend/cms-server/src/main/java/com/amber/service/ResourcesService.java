package com.amber.service;

import com.amber.dto.resources.CreateResourceDTO;
import com.amber.dto.resources.ResourcesPageQueryDTO;
import com.amber.entity.Resources;
import com.amber.result.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ResourcesService extends IService<Resources> {

    PageResult pageQuery(ResourcesPageQueryDTO resourcesPageQueryDTO);

    void createResource(CreateResourceDTO createResourceDTO);
}

