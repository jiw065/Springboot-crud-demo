package com.springboot.demo.config.dao;

import java.beans.PropertyVetoException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Database connection configuration -- dataSource
 * @author Amber
 *
 */

@Configuration
@MapperScan("com.springboot.demo.dao")
public class DataSourceConfig {
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUser;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Bean(name="dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource= new ComboPooledDataSource();
		dataSource.setDriverClass(jdbcDriver);;
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(jdbcUser);
		dataSource.setPassword(jdbcPassword);
		//do not commit after close the connection
		dataSource.setAutoCommitOnClose(false);
		
		
		return dataSource;
	}
}
