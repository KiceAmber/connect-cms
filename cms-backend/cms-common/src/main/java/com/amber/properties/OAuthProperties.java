package com.amber.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "oauth")
@Data
public class OAuthProperties {

    private String clientId;
    private String clientSecret;
}
