package com.amber.dao;

import com.amber.dto.tags.TagsPageQueryDTO;
import com.amber.entity.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;

public interface TagsDao extends BaseMapper<Tags> {

    void insertOneRecord(Tags tags);

    Page<Tags> pageQuery(TagsPageQueryDTO tagsPageQueryDTO);
}

