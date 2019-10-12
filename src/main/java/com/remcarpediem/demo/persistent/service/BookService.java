/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent.service;

import com.remcarpediem.demo.persistent.dao.BookDao;
import com.remcarpediem.demo.persistent.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author libing
 * @version $Id: BookService.java, v 0.1 2019年10月12日 下午4:57 zt Exp $
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public BookEntity getBookDetail(Long id) {
        return bookDao.selectById(id);
    }
}