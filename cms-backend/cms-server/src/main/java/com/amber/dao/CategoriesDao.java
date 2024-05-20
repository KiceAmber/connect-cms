package com.amber.dao;

import com.amber.dto.categories.CategoriesPageQueryDTO;
import com.amber.entity.Categories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;

public interface CategoriesDao extends BaseMapper<Categories> {

    void insertOneRecord(Categories categories);

    Page<Categories> pageQuery(CategoriesPageQueryDTO categoriesPageQueryDTO);
}

