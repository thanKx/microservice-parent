package org.xieq.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xieq.system.service.ProductService;

/**
 * @author xieq
 * @date 2023/6/29 15:12
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/reduce/{id}")
    public Boolean reduce(@PathVariable Integer id){
        return productService.reduce(id);
    }

}
