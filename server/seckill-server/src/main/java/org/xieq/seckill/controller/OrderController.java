package org.xieq.seckill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xieq.seckill.service.OrderService;

/**
 * @author xieq
 * @date 2023/6/29 15:03
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Boolean insert(){
        return orderService.insert();
    }
}
