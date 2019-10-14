/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent.dao;

import com.remcarpediem.demo.persistent.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author libing
 * @version $Id: OrderDao.java, v 0.1 2019年10月12日 下午4:51 zt Exp $
 */
@Mapper
public interface OrderDao {
    @Select("select * from t_order WHERE order_id = #{id} AND role_id = #{roleId}")
    OrderEntity selectById(@Param("id") Long id, @Param("roleId") Long roleId);

    @Insert("insert into t_order (order_id,role_id,time,state) VALUE (#{orderId},#{roleId},#{time},#{state})")
    void insert(OrderEntity orderEntity);

}