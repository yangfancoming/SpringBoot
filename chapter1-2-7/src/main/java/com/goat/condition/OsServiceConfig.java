package com.goat.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2019/2/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/4---18:24
 */
@Configuration
public class OsServiceConfig {

    @Bean
    @Conditional(LinuxCondition.class) // 条件判断 true 则创建该bean  false 则不会创建该bean
    public ListService linuxListService() {
        return new LinuxListService();
    }

    @Bean
    @Conditional(WindowsCondition.class) // 条件判断 true 则创建该bean  false 则不会创建该bean
    public ListService windowsListService() {
        return new WindowsListService();
    }

}