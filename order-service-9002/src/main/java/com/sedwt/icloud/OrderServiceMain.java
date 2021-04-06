package com.sedwt.icloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : zhang yijun
 * @date : 2021/3/12 15:49
 * @description : TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain.class, args);
    }
}
