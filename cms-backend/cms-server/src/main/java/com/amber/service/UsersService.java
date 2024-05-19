package com.amber.service;

import com.amber.dto.users.CreateUserDTO;
import com.amber.dto.users.UsersLoginDTO;
import com.amber.dto.users.UsersPageQueryDTO;
import com.amber.entity.Users;
import com.amber.result.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;


public interface UsersService extends IService<Users> {

    Users login(UsersLoginDTO usersLoginDTO);

    void createUser(CreateUserDTO createUserDTO);

    PageResult pageQuery(UsersPageQueryDTO usersPageQueryDTO);
}

