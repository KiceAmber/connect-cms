package com.amber.dao;

import com.amber.entity.Posts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * (Posts)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
public interface PostsDao extends BaseMapper<Posts> {

    void insertOneRecord(Posts posts);
}

