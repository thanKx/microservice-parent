package org.xieq.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xieq
 * @date 2023/6/21 08:48
 */
@FeignClient(contextId = "testFeignClient", value = "system")
public interface TestFeignClient {

    @GetMapping("hello")
    String hello();
}
