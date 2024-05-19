package com.amber.dao;

import com.amber.entity.Categories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CategoriesDao extends BaseMapper<Categories> {

    void insertOneRecord(Categories categories);
}

