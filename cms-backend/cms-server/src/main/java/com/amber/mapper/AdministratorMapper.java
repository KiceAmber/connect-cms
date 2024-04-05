package com.amber.mapper;

import com.amber.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface AdministratorMapper {

    @Select("select id, name, password, status, create_time from connect_cms.cms_admin where name = #{name} limit 1")
    Admin getByName(String name);
}
