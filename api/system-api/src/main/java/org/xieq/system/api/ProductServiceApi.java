package org.xieq.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author xieq
 * @date 2023/6/29 15:10
 */
@FeignClient(contextId = "productServiceApi", value = "system", path = "/product")
public interface ProductServiceApi {

    @PostMapping("/reduce/{id}")
    String reduce(@PathVariable(value = "id") Integer id);

}
