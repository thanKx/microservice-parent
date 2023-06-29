package org.xieq.system.service;

import org.xieq.system.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xieq
* @description 针对表【product】的数据库操作Service
* @createDate 2023-06-29 15:01:43
*/
public interface ProductService extends IService<Product> {

    Boolean reduce(Integer id);
}
