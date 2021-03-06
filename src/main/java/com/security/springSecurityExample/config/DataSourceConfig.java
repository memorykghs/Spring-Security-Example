package com.security.springSecurityExample.config;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

/**
 * <pre>
 * Connection Pool 
 * use HikariCP
 * </pre>
 * 
 * @author memorykghs
 */
//@Configuration
//public class DataSourceConfig {
//
//	@Value("${DBUrl}")
//	private String dataSourceUrl;
//	
//	private Logger logger = Logger.getLogger(getClass().getName());
//
//	@Bean("localDataSource")
//	@Primary
////	@Profile("local")
//	public DataSource getLocalDataSource() {
//		return DataSourceBuilder
//				.create()
//				.type(HikariDataSource.class) // HikariCP
//				.username("root")
//				.password("Ashley2020")
//				.url(dataSourceUrl)
//				.build();
//	}
//}
