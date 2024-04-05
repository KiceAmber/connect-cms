package com.amber.service.impl;

import com.amber.constant.MessageConstant;
import com.amber.constant.StatusConstant;
import com.amber.dto.AdminLoginDTO;
import com.amber.entity.Admin;
import com.amber.exception.AccountLockedException;
import com.amber.exception.AccountNotFoundException;
import com.amber.exception.PasswordErrorException;
import com.amber.mapper.AdministratorMapper;
import com.amber.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Admin login(AdminLoginDTO adminLoginDTO) {
        String name = adminLoginDTO.getName();
        String password = adminLoginDTO.getPassword();

        Admin admin = administratorMapper.getByName(name);
        log.info("admin info is " + admin);

        if (admin == null) {
            // 管理员账号不存在
            throw new AccountNotFoundException(MessageConstant.ADMIN_ACCOUNT_NOT_FOUND);
        }

        // md5 加密，再进行比对数据库的密码是否一致
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPassword())) {
            // 密码错误
            throw new PasswordErrorException(MessageConstant.ADMIN_PASSWORD_ERROR);
        }

        if (admin.getStatus().equals(StatusConstant.DISABLE)) {
            // 账号被锁定
            throw new AccountLockedException(MessageConstant.ADMIN_ACCOUNT_LOCKED);
        }

        // 返回实体对象
        return admin;
    }
}
