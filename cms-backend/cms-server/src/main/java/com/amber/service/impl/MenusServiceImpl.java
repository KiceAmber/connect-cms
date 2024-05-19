package com.amber.service.impl;

import com.amber.dao.MenusDao;
import com.amber.dto.menus.CreateMenuDTO;
import com.amber.dto.menus.MenusPageQueryDTO;
import com.amber.entity.Menus;
import com.amber.result.PageResult;
import com.amber.service.MenusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * (Menus)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("menusService")
public class MenusServiceImpl extends ServiceImpl<MenusDao, Menus> implements MenusService {

    @Resource
    private MenusDao menusDao;

    @Override
    public void createMenu(CreateMenuDTO createMenusDTO) {
        Menus menus = Menus.builder().
                url(createMenusDTO.getUrl()).
                title(createMenusDTO.getTitle()).
                name(createMenusDTO.getName()).
                icon(createMenusDTO.getIcon()).
                parentId(createMenusDTO.getParentId()).
                createTime(LocalDateTime.now()).
                build();

        menusDao.insertOneRecord(menus);
    }

    @Override
    public PageResult pageQuery(MenusPageQueryDTO menusPageQueryDTO) {
        PageHelper.startPage(menusPageQueryDTO.getPage(), menusPageQueryDTO.getSize());
        Page<Menus> page = menusDao.pageQuery(menusPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}

