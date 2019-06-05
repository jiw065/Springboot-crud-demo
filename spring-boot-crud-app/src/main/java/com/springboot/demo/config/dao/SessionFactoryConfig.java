package com.springboot.demo.config.dao;


import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfig {
	@Value("${mybatis_config_file_path}")
	private String mybatisConfigFilePath;
	@Value("${mapper_path}")
	private String mapperPath;

	@Value("${entity_package}")
	private String entityPackage;
	
	@Autowired
	private DataSource dataSource;

	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		//find mybatis-config.xml
		factory.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		//find mapper 
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
		factory.setMapperLocations(resolver.getResources(packageSearchPath));
		//points to DataSourceConfig 
		factory.setDataSource(dataSource);
		// find entity class
		factory.setTypeAliasesPackage(entityPackage);
		return factory;
	}
}
