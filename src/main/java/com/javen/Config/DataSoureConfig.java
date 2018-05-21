package com.javen.Config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;

@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages="com.javen.dao")

public class DataSoureConfig {



	@Bean
	public Slf4jLogFilter getSlf4jLogFilter() {
		Slf4jLogFilter slf = new Slf4jLogFilter();
		slf.setConnectionLogEnabled(true);
		slf.setStatementLogEnabled(true);
		slf.setResultSetLogEnabled(true);
		slf.setStatementExecutableSqlLogEnable(true);
		return slf;
	}
    @Autowired
    Environment env;

	@Bean(name = "DataSourcemysql", autowire = Autowire.BY_NAME)
	public DataSource DataSourcemysql() throws PropertyVetoException,
			SQLException {
		System.out.println(env.getProperty("username.mysql"));
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setUsername(env.getProperty("username.mysql"));
		dataSource.setPassword(env.getProperty("password.mysql"));
		dataSource.setInitialSize(0);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(1);
		dataSource.setMaxWait(60000);
		dataSource.setFilters("log4j");
		List<Filter> filters = new ArrayList<>();
		filters.add(getSlf4jLogFilter());
		dataSource.setProxyFilters(filters);
		dataSource.init();

		return dataSource;
	}

	@Bean(name = "SqlSessionFactoryBean")
	public SqlSessionFactoryBean getSqlSessionFactoryBean()
			throws PropertyVetoException, SQLException {
		SqlSessionFactoryBean SqlSessionFactoryBean = new SqlSessionFactoryBean();
		SqlSessionFactoryBean.setDataSource(DataSourcemysql());
		return SqlSessionFactoryBean;

	}


	@Bean
	public  DataSourceTransactionManager getDataSourceTransactionManager() throws PropertyVetoException, SQLException
	{
		
		DataSourceTransactionManager DataSourceTransactionManager =new DataSourceTransactionManager();
		DataSourceTransactionManager.setDataSource(DataSourcemysql());
		return DataSourceTransactionManager;
		
	}

	
	

}
