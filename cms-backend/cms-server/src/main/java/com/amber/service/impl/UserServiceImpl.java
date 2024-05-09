package com.amber.service.impl;

import com.amber.constant.MessageConstant;
import com.amber.dto.UserLoginDTO;
import com.amber.entity.User;
import com.amber.exception.AccountNotFoundException;
import com.amber.exception.PasswordErrorException;
import com.amber.mapper.UserMapper;
import com.amber.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String passport = userLoginDTO.getPassport();
        String password = userLoginDTO.getPassword();

        User user = userMapper.getByName(passport);
        log.info("user info is " + user);

        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.USER_ACCOUNT_NOT_FOUND);
        }

        // md5 加密，再进行比对数据库的密码是否一致
        // TODO: 后续使用盐值加密，这里使用的还是普通的 MD5 加密，不太安全
        // 为每一个用户生成属于自己的唯一盐值，在用户设置密码时，将盐值添加到密码后边
        // 再将拼接而成的密码进行 MD5 加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.USER_PASSWORD_ERROR);
        }

        return user;
    }
}
