package com.amber.service.impl;

import com.amber.dao.TagsDao;
import com.amber.dto.tags.CreateTagDTO;
import com.amber.dto.tags.TagsPageQueryDTO;
import com.amber.entity.Tags;
import com.amber.result.PageResult;
import com.amber.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public void createTag(CreateTagDTO createTagDTO) {
        Tags tags = Tags.builder().
                name(createTagDTO.getName()).
                description(createTagDTO.getDescription()).
                createTime(LocalDateTime.now()).
                build();
        tagsDao.insertOneRecord(tags);
    }

    @Override
    public PageResult pageQuery(TagsPageQueryDTO tagsPageQueryDTO) {
        PageHelper.startPage(tagsPageQueryDTO.getPage(), tagsPageQueryDTO.getSize());
        Page<Tags> page = tagsDao.pageQuery(tagsPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

}

