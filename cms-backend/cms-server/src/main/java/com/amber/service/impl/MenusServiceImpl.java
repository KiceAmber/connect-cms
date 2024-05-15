package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.MenusDao;
import com.amber.entity.Menus;
import com.amber.service.MenusService;
import org.springframework.stereotype.Service;

/**
 * (Menus)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("menusService")
public class MenusServiceImpl extends ServiceImpl<MenusDao, Menus> implements MenusService {

}

