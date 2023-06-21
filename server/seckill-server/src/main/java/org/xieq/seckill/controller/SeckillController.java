package org.xieq.seckill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xieq.system.api.TestFeignClient;

/**
 * @author xieq
 * @date 2023/6/21 14:30
 */
@RestController
public class SeckillController {

    @Autowired
    private TestFeignClient testFeignClient;

    @GetMapping("/seckill")
    public String seckill(){
        return testFeignClient.hello() + "秒杀";
    }
}
