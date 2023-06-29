package org.xieq.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.xieq.system.domain.Product;
import org.xieq.system.service.ProductService;
import org.xieq.system.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author xieq
* @description 针对表【product】的数据库操作Service实现
* @createDate 2023-06-29 15:01:43
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

    @Override
    public Boolean reduce(Integer id) {
        Product product = this.getById(id);
        product.setStoreNum(product.getStoreNum()-1);

        boolean b = this.updateById(product);
        return b;
    }
}




