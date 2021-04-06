package com.sedwt.icloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : zhang yijun
 * @date : 2021/3/12 16:17
 * @description : TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceMain.class, args);
    }
}
