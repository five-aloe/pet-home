/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.dal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载SPRING配置文件
 * 
 * @author zyf
 *
 */
@Configuration
@ImportResource(locations= {
	"classpath:spring/spring-redis.xml"
})
@ImportAutoConfiguration(classes= {DouxinDataSourceConfig.class})
public class SpringDalConfigs {

}
