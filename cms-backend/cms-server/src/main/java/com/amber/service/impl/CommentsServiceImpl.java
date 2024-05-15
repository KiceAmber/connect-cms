package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.CommentsDao;
import com.amber.entity.Comments;
import com.amber.service.CommentsService;
import org.springframework.stereotype.Service;

/**
 * (Comments)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, Comments> implements CommentsService {

}

