/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 *
 * @author libing
 * @version $Id: OrderEntity.java, v 0.1 2019年10月12日 下午4:56 zt Exp $
 */
@Data
public class OrderEntity {
    private Long orderId;
    private Long roleId;
    private Integer state;
    private Timestamp time;
}