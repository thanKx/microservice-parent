package org.xieq.seckill.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.xieq.seckill.domain.Order;
import org.xieq.seckill.service.OrderService;
import org.xieq.seckill.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.xieq.system.api.ProductServiceApi;

import java.time.LocalDateTime;

/**
* @author xieq
* @description 针对表【order(定点表)】的数据库操作Service实现
* @createDate 2023-06-29 14:58:58
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private ProductServiceApi productServiceApi;

    @Override
    @GlobalTransactional
    public Boolean insert() {

        Order order = new Order();
        order.setOrderPrice(1000);
        order.setOrderName("电脑订单-" + DateUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss"));
        order.setProductId(1);

        productServiceApi.reduce(order.getProductId());
        return this.save(order);
    }
}




