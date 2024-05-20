package com.amber.service.impl;

import com.amber.dao.CategoriesDao;
import com.amber.dto.categories.CategoriesPageQueryDTO;
import com.amber.dto.categories.CreateCategoryDTO;
import com.amber.entity.Categories;
import com.amber.result.PageResult;
import com.amber.service.CategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public PageResult pageQuery(CategoriesPageQueryDTO categoriesPageQueryDTO) {
        PageHelper.startPage(categoriesPageQueryDTO.getPage(), categoriesPageQueryDTO.getSize());
        Page<Categories> page = categoriesDao.pageQuery(categoriesPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}

