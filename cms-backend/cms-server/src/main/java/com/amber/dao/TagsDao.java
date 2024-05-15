package com.amber.dao;

import com.amber.entity.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * (Tags)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
public interface TagsDao extends BaseMapper<Tags> {

    @Insert("insert into tags(name,description,create_time) values(#{name},#{description},#{createTime})")
    void insertOne(Tags tags);
}

