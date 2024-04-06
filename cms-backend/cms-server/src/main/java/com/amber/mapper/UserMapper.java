package com.amber.mapper;

import com.amber.entity.Admin;
import com.amber.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("select id, name, password, create_time from connect_cms.cms_user where name = #{name} limit 1")
    User getByName(String name);
}
