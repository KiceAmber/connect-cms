package com.amber.service.impl;

import com.amber.constant.FieldConstant;
import com.amber.constant.MessageConstant;
import com.amber.dao.UsersDao;
import com.amber.dto.users.CreateUsersDTO;
import com.amber.dto.users.UsersLoginDTO;
import com.amber.entity.Users;
import com.amber.exception.PasswordErrorException;
import com.amber.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.security.auth.login.AccountNotFoundException;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Service("usersService")
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersDao, Users> implements UsersService {

    @Resource
    private UsersDao usersDao;

    @Override
    public Users login(UsersLoginDTO usersLoginDTO) {
        String passport = usersLoginDTO.getPassport();
        String password = usersLoginDTO.getPassword();

        Users user = usersDao.getByName(passport);
        log.info("user info is " + user);

        if (user == null) {
            try {
                throw new AccountNotFoundException(MessageConstant.USER_ACCOUNT_NOT_FOUND);
            } catch (AccountNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // 为每一个用户生成属于自己的唯一盐值，在用户设置密码时，将盐值添加到密码后边
        // 再将拼接而成的密码进行 MD5 加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.USER_PASSWORD_ERROR);
        }

        return user;
    }

    @Override
    public Boolean createUser(CreateUsersDTO createUsersDTO) {
        // 创建用户䣌逻辑
        Users users = null;
        if (createUsersDTO != null) {
            users = Users.builder().
                    passport(createUsersDTO.getPassport()).
                    nickname(createUsersDTO.getNickname()).
                    password(DigestUtils.md5DigestAsHex(createUsersDTO.getPassword().getBytes())).
                    email(createUsersDTO.getEmail()).
                    avatar(FieldConstant.DEFAULT_AVATAR).
                    roleId(createUsersDTO.getRoleId()).
                    build();
            return usersDao.insertOneRecord(users);
        } else {
            return false;
        }
    }
}

