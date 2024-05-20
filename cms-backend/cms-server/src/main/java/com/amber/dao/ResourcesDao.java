package com.amber.dao;

import com.amber.dto.resources.ResourcesPageQueryDTO;
import com.amber.entity.Resources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;

public interface ResourcesDao extends BaseMapper<Resources> {

    void insertOneRecord(Resources resources);

    Page<Resources> pageQuery(ResourcesPageQueryDTO resourcesPageQueryDTO);
}

