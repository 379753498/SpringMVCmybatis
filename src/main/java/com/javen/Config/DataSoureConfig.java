package com.javen.Config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;

@Configuration
public class DataSoureConfig {

	@Autowired
	Slf4jLogFilter Slf4jLogFilter;

	@Value("${driver}")
	String driverClass;
	@Value("${url}")
	String url;
	@Value("${username}")
	String username;
	@Value("${password}")
	String password;

	@Bean(name = "DataSourcemysql", autowire = Autowire.BY_NAME)
	public DataSource DataSourcemysql() throws PropertyVetoException,
			SQLException {
		System.out.println(driverClass);

		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(0);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(1);
		dataSource.setMaxWait(60000);
		dataSource.setFilters("log4j");
		List<Filter> filters = new ArrayList<>();
		filters.add(Slf4jLogFilter);
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
	public MapperScannerConfigurer getMapperScannerConfigurer()

	{MapperScannerConfigurer MapperScannerConfigurer =new  MapperScannerConfigurer();
		MapperScannerConfigurer.setBasePackage("com.javen.dao");
		MapperScannerConfigurer.setSqlSessionFactoryBeanName("SqlSessionFactoryBean");
		return MapperScannerConfigurer;
	}
	@Bean
	public  DataSourceTransactionManager getDataSourceTransactionManager() throws PropertyVetoException, SQLException
	{
		
		DataSourceTransactionManager DataSourceTransactionManager =new DataSourceTransactionManager();
		DataSourceTransactionManager.setDataSource(DataSourcemysql());
		return DataSourceTransactionManager;
		
	}

	
	

}
