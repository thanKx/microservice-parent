package org.xieq.seckill.service;

import org.xieq.seckill.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xieq
* @description 针对表【order(定点表)】的数据库操作Service
* @createDate 2023-06-29 14:58:58
*/
public interface OrderService extends IService<Order> {

    Boolean insert();
}
