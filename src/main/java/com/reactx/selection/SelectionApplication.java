package com.reactx.selection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@EnableCaching
@ServletComponentScan
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.reactx.selection.mappers")
public class SelectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelectionApplication.class, args);
    }

}
