package com.amber.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.amber.dao.AttachmentsDao;
import com.amber.entity.Attachments;
import com.amber.service.AttachmentsService;
import org.springframework.stereotype.Service;

/**
 * (Attachments)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:52
 */
@Service("attachmentsService")
public class AttachmentsServiceImpl extends ServiceImpl<AttachmentsDao, Attachments> implements AttachmentsService {

}

