package com.amber.controller.admin;

import com.amber.constant.JwtClaimsConstant;
import com.amber.dto.AdminLoginDTO;
import com.amber.entity.Admin;
import com.amber.properties.JwtProperties;
import com.amber.result.Result;
import com.amber.service.AdministratorService;
import com.amber.utils.JwtUtil;
import com.amber.vo.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/admin/administrator")
@Api(tags = "管理员相关接口")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @ApiOperation("管理员登录")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        log.info("管理员登录：{}", adminLoginDTO);

        Admin admin = administratorService.login(adminLoginDTO);

        // 登录成功后，生成 jwt 令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ADMIN_ID, admin.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .name(admin.getName())
                .token(token)
                .build();

        return Result.success(adminLoginVO);
    }
}
