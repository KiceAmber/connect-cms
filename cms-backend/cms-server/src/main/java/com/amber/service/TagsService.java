package com.amber.service;

import com.amber.dto.tags.CreateTagsDTO;
import com.amber.entity.Tags;
import com.amber.vo.tags.CreateTagsVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (Tags)表服务接口
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
public interface TagsService extends IService<Tags> {

    CreateTagsVO createTag(CreateTagsDTO createTagsDTO);
}

