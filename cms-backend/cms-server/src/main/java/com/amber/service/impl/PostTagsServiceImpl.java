package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.PostTagsDao;
import com.amber.entity.PostTags;
import com.amber.service.PostTagsService;
import org.springframework.stereotype.Service;

/**
 * (PostTags)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("postTagsService")
public class PostTagsServiceImpl extends ServiceImpl<PostTagsDao, PostTags> implements PostTagsService {

}

