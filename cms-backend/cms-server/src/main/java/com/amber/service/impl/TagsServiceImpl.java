package com.amber.service.impl;

import com.amber.dao.TagsDao;
import com.amber.dto.tags.CreateTagsDTO;
import com.amber.entity.Tags;
import com.amber.service.TagsService;
import com.amber.vo.tags.CreateTagsVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * (Tags)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Service("tagsService")
public class TagsServiceImpl extends ServiceImpl<TagsDao, Tags> implements TagsService {

    @Resource
    private TagsDao tagsDao;

    @Override
    public CreateTagsVO createTag(CreateTagsDTO createTagsDTO) {
        String name = createTagsDTO.getName();
        String description = createTagsDTO.getDescription();

        Tags tags = Tags.builder().
                name(name).
                description(description).
                createTime(LocalDateTime.now()).
                build();
        tagsDao.insertOne(tags);
        return null;
    }
}

