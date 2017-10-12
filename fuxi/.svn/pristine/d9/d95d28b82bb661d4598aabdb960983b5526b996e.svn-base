/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.biz.config;

import org.springframework.context.annotation.ComponentScan;
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
	"classpath:spring/activemq.xml",
	"classpath:spring/spring-dubbo.xml"
})
@ComponentScan("com.zhonglian.fuxi.service")
public class SpringBizConfigs {

}
