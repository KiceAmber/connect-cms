package com.amber.mapper;

import com.amber.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("select id, passport, password, created_at from connect_cms.users where passport = #{passport} limit 1")
    User getByName(String name);
}
