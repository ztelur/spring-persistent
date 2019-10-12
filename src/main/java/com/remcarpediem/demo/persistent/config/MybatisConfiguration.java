/**
 * Superid.menkor.com Inc.
 * Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.remcarpediem.demo.persistent.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author libing
 * @version $Id: MybatisConfiguration.java, v 0.1 2019年10月12日 下午4:28 zt Exp $
 */

@Configuration
@MapperScan(basePackages = "com.remcarpediem.demo.persistent.dao")
public class MybatisConfiguration {
}