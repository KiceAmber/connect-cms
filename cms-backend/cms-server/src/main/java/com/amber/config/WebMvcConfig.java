package com.amber.config;

import com.amber.interceptor.JwtAdminInterceptor;
import com.amber.json.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
@Slf4j
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtAdminInterceptor jwtAdminInterceptor;

    /**
     * 注册自定义拦截器
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(jwtAdminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/administrator/login");
    }

    /**
     * 通过knife4j生成接口文档
     */
    @Bean
    public Docket docket1() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("connect-cms 接口文档")
                .version("2.0")
                .description("connect-cms接口文档")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理端接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.amber.controller.admin"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket docket2() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("connect-cms 接口文档")
                .version("2.0")
                .description("connect-cms接口文档")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户端接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.amber.controller.user"))
                .paths(PathSelectors.any())
                .build();
    }

    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 设置 swagger 的静态资源映射
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 扩展 SpringMVC 框架的消息转化器：日期格式化转换
     *
     * @param converters 日期格式转换器
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建一个消息转换器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // 为消息转换器设置一个对象转换器，对象转换器可以让 Java 对象序列化为 json 数据
        converter.setObjectMapper(new JacksonObjectMapper());
        // 加入到 converters 中，并且将优先级设置为 0，这样就会优先使用自定义的转换器
        converters.add(0, converter);
    }
}
