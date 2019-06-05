package com.springboot.demo.config.dao;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfig {
	private String mybatisConfigFilePath;

	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		//String packageSearchPath 
	}
}
