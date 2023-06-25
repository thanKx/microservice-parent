package org.xieq.system.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xieq
 * @date 2023/6/20 14:52
 */
@RestController
@RequestMapping
@RefreshScope
public class HelloController {

    @Value("${message:nacos}")
    private String message;
    @GetMapping("hello")
    public String hello() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "你好呀," + message;
    }

}
