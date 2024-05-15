package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.OptionsDao;
import com.amber.entity.Options;
import com.amber.service.OptionsService;
import org.springframework.stereotype.Service;

/**
 * (Options)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("optionsService")
public class OptionsServiceImpl extends ServiceImpl<OptionsDao, Options> implements OptionsService {

}

