package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.CategoriesDao;
import com.amber.entity.Categories;
import com.amber.service.CategoriesService;
import org.springframework.stereotype.Service;

/**
 * (Categories)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("categoriesService")
public class CategoriesServiceImpl extends ServiceImpl<CategoriesDao, Categories> implements CategoriesService {

}

