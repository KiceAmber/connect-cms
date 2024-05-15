package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.PostsDao;
import com.amber.entity.Posts;
import com.amber.service.PostsService;
import org.springframework.stereotype.Service;

/**
 * (Posts)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("postsService")
public class PostsServiceImpl extends ServiceImpl<PostsDao, Posts> implements PostsService {

}

