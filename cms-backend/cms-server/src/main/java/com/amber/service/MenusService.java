package com.amber.service;

import com.amber.dto.menus.CreateMenuDTO;
import com.amber.dto.menus.MenusPageQueryDTO;
import com.amber.entity.Menus;
import com.amber.result.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;


public interface MenusService extends IService<Menus> {

    void createMenu(CreateMenuDTO createMenusDTO);

    PageResult pageQuery(MenusPageQueryDTO menusPageQueryDTO);
}

