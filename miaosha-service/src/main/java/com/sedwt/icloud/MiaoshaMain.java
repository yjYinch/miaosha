package com.sedwt.icloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : zhang yijun
 * @date : 2021/3/16 10:04
 * @description : TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MiaoshaMain {
    public static void main(String[] args) {
        SpringApplication.run(MiaoshaMain.class, args);
    }
}
