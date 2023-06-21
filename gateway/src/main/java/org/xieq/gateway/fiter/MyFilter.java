package org.xieq.gateway.fiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.xieq.system.api.TestFeignClient;
import reactor.core.publisher.Mono;

/**
 * @author xieq
 * @date 2023/6/21 09:32
 */
@Component
public class MyFilter implements GlobalFilter {

    @Autowired
    private TestFeignClient testFeignClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("进入过滤器");

        System.out.println(testFeignClient.hello());

        return chain.filter(exchange);
    }
}
