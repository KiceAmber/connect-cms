package com.amber.service;

import com.amber.dto.categories.CreateCategoryDTO;
import com.amber.entity.Categories;
import com.baomidou.mybatisplus.extension.service.IService;


public interface CategoriesService extends IService<Categories> {

    void createCategory(CreateCategoryDTO createCategoryDTO);
}

