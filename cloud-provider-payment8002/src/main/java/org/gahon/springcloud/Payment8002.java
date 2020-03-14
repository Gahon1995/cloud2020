package org.gahon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gahon
 * @date 2020/3/13
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class, args);
    }
}
