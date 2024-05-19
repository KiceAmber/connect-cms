package com.amber.service.impl;

import com.amber.dao.CategoriesDao;
import com.amber.dto.categories.CreateCategoryDTO;
import com.amber.entity.Categories;
import com.amber.service.CategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service("categoriesService")
public class CategoriesServiceImpl extends ServiceImpl<CategoriesDao, Categories> implements CategoriesService {

    @Resource
    private CategoriesDao categoriesDao;

    @Override
    public void createCategory(CreateCategoryDTO createCategoryDTO) {
        Categories categories = Categories.builder()
                .parentId(createCategoryDTO.getParentId())
                .name(createCategoryDTO.getName())
                .description(createCategoryDTO.getDescription())
                .slug(createCategoryDTO.getSlug())
                .createTime(LocalDateTime.now())
                .build();
        categoriesDao.insertOneRecord(categories);
    }
}

