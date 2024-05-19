package com.amber.service;

import com.amber.dto.tags.CreateTagDTO;
import com.amber.dto.tags.TagsPageQueryDTO;
import com.amber.entity.Tags;
import com.amber.result.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TagsService extends IService<Tags> {

    void createTag(CreateTagDTO createTagDTO);

    PageResult pageQuery(TagsPageQueryDTO tagsPageQueryDTO);
}

