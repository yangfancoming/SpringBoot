package com.goat.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
     * @author: Goat
     * @Date:   2019/1/13
     *  在Oauth2的授权中 必须要增加 该类 实现 WebSecurityConfigurerAdapter
     *  否则报错： org.springframework.security.authentication.InsufficientAuthenticationException: User must be authenticated with Spring Security before authorization can be completed.
*/
@Configuration
@EnableWebSecurity // 启用 springsecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override //inMemoryAuthentication 从内存中获取
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("user1").password(passwordEncoder().encode("123456")).roles("USER").and()
                .withUser("admin").password("123456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();
    }

    // 如果不配置 PasswordEncoder  则报错：  "There is no PasswordEncoder mapped for the id \"null\"",
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /*
    *  不加 以下 代码 会报错：
    * Field authenticationManager in com.goat.config.OAuth2ServerConfig$AuthorizationServerConfiguration required a bean of type
    *  'org.springframework.security.authentication.AuthenticationManager' that could not be found.
    * */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
}