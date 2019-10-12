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
 * @version $Id: BookEntity.java, v 0.1 2019年10月12日 下午4:56 zt Exp $
 */
@Data
public class BookEntity {
    private Long id;
    private String name;
    private Timestamp time;
}