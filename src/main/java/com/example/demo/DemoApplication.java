package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/20
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
