package com.amber.service;

import com.amber.dto.users.CreateUsersDTO;
import com.amber.dto.users.UsersLoginDTO;
import com.amber.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
public interface UsersService extends IService<Users> {

    Users login(UsersLoginDTO usersLoginDTO);

    Boolean createUser(CreateUsersDTO createUsersDTO);
}

