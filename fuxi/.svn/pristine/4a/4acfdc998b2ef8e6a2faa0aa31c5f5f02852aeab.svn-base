package com.zhonglian.fuxi;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.zhonglian.fuxi.biz.config.SpringBizConfigs;
import com.zhonglian.fuxi.dal.config.SpringDalConfigs;
import com.zhonglian.fuxi.web.config.SpringWebConfig;

@SpringBootApplication(exclude= {MybatisAutoConfiguration.class})
@Import({SpringWebConfig.class, SpringBizConfigs.class, SpringDalConfigs.class})
public class FuxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuxiApplication.class, args);
	}
}
