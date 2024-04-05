package com.amber.service;

import com.amber.dto.AdminLoginDTO;
import com.amber.entity.Admin;

public interface AdministratorService {

    /**
     * 管理员登录
     *
     * @param adminLoginDTO
     * @return
     */
    Admin login(AdminLoginDTO adminLoginDTO);
}
