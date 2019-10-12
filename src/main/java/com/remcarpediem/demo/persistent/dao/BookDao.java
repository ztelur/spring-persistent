/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent.dao;

import com.remcarpediem.demo.persistent.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author libing
 * @version $Id: BookDao.java, v 0.1 2019年10月12日 下午4:51 zt Exp $
 */
@Mapper
public interface BookDao {
    @Select("select * from BOOK WHERE id = #{id}")
    BookEntity selectById(@Param("id") Long id);

    void insert(BookEntity bookEntity);
}