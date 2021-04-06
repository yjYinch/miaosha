package com.sedwt.icloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:16
 * @description : TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceMain.class, args);
    }
}
