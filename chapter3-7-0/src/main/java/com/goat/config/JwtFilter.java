package com.goat.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2018/11/20.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/20---15:21
 */
@Configuration
public class JwtFilter {

    @Bean
    public FilterRegistrationBean myJwtFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
        return new FilterRegistrationBean(jwtAuthenticationFilter);
    }
}
