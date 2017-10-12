/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.dal.config;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;

import com.zhonglian.fuxi.dal.config.DouxinDataSourceConfig.DouxinMybatisProperties;

/**
 * @author zyf
 *
 */
@Configuration
@MapperScan(value= {"com.zhonglian.fuxi.dal.mapper"}, sqlSessionTemplateRef="douxinSessionTemplate")
@EnableConfigurationProperties(DouxinMybatisProperties.class)
public class DouxinDataSourceConfig extends MybatisAutoConfiguration {

	public DouxinDataSourceConfig(DouxinMybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
			ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider,
			ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
		super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
	}


	@Bean(name = "douxinDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
	public DataSource createDataSouce() {
		
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name = "douxinSqlSessionFactory")
	@Override
	public SqlSessionFactory sqlSessionFactory(@Qualifier("douxinDataSource") DataSource dataSource) throws Exception {
		return super.sqlSessionFactory(dataSource);
	}
	

    @Bean(name = "douxinSessionTemplate")
    @Primary
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier("douxinSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
    @ConfigurationProperties(prefix = DouxinMybatisProperties.DOUXIN_MYBATIS_PREFIX)
    public static class DouxinMybatisProperties extends MybatisProperties {

    	public static final String DOUXIN_MYBATIS_PREFIX = "mybatis";
    	
    }
}
