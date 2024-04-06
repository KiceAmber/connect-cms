package com.amber.service;

import com.amber.dto.UserLoginDTO;
import com.amber.entity.User;

public interface UserService {
    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);
}
