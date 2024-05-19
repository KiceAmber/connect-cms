package com.amber.dao;

import com.amber.dto.menus.MenusPageQueryDTO;
import com.amber.entity.Menus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;

/**
 * (Menus)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
public interface MenusDao extends BaseMapper<Menus> {

    void insertOneRecord(Menus menus);

    Page<Menus> pageQuery(MenusPageQueryDTO menusPageQueryDTO);
}

