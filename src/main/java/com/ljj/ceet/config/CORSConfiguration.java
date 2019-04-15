package com.ljj.ceet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @CLassName CORSConfiguration
 * @Description 配置类，用于允许所有的请求都跨域。
 * @Author LeeJack
 * @Date 2019/3/26/026 22:58
 * @Version 1.0
 */
@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter/*todo*/ {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
