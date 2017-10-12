/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.biz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 测试启动类
 * @author zyf
 *
 */
@EnableAutoConfiguration(exclude= {MybatisAutoConfiguration.class})
@SpringBootApplication
public class TestApplication {
	
	private static Log logger = LogFactory.getLog(TestApplication.class);
	

	/**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }
	
}
