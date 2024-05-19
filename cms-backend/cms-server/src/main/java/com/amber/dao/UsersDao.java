package com.amber.dao;

import com.amber.dto.users.UsersPageQueryDTO;
import com.amber.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
public interface UsersDao extends BaseMapper<Users> {

    @Select("select id, passport, password, create_time from connect_cms.users where passport = #{passport} limit 1")
    Users getByName(String passport);

    void insertOneRecord(Users users);

    Page<Users> pageQuery(UsersPageQueryDTO tagsPageQueryDTO);
}

