/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent.service;

import com.remcarpediem.demo.persistent.dao.OrderDao;
import com.remcarpediem.demo.persistent.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 *
 * @author libing
 * @version $Id: BookService.java, v 0.1 2019年10月12日 下午4:57 zt Exp $
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public OrderEntity getOrderDetail(Long id, Long roleId) {
        return orderDao.selectById(id, roleId);
    }


    public void createOrder(Long orderId, Long roleId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderId);
        orderEntity.setRoleId(roleId);
        orderEntity.setState(1);
        orderEntity.setTime(new Timestamp(System.currentTimeMillis()));
        orderDao.insert(orderEntity);
    }
}