package com.amber.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cms.jwt")
@Data
public class JwtProperties {

    /**
     * 用户端生成 jwt 令牌相关配置
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

}