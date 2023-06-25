package org.xieq.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xieq
 * @date 2023/6/21 14:25
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "org.xieq.system.api")
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }

}
