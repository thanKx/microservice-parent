package org.xieq.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xieq
 * @date 2023/6/20 16:57
 */
@SpringBootApplication
@EnableFeignClients
@ComponentScan({"org.xieq.gateway", "org.xieq.system.api"})
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
