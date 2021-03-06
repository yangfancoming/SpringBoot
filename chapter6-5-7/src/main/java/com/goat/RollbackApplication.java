package com.goat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableRetry // 启动Spring retry
@EnableAsync
@EnableJpaAuditing
public class RollbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(RollbackApplication.class, args);
    }

}
