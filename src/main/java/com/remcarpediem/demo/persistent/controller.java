/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent;

import com.remcarpediem.demo.persistent.entity.BookEntity;
import com.remcarpediem.demo.persistent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author libing
 * @version $Id: controller.java, v 0.1 2019年10月12日 下午4:50 zt Exp $
 */
@RestController
public class controller {
    @Autowired
    private OrderService orderService;

    @GetMapping("/test")
    public BookEntity getBook() {
        return orderService.getBookDetail(1L);
    }
}