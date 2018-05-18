package com.javen.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Configuration
@ComponentScan(basePackages="com.javen.*")

public class RootConfig {
	
	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setIgnoreResourceNotFound(true);
		final List<Resource> resourceLst = new ArrayList<Resource>();
		resourceLst.add(new ClassPathResource("jdbc.properties"));
		resourceLst.add(new ClassPathResource("mail.properties"));
		resourceLst.add(new ClassPathResource("redis.properties"));
		ppc.setLocations(resourceLst.toArray(new Resource[] {}));

		System.out.println("aaaa");
		return ppc;

	}
	@Bean
	public DefaultKaptcha getDefaultKaptcha()
	{
		DefaultKaptcha DefaultKaptcha = new DefaultKaptcha();
		Properties Properties =new Properties();
		Properties.put("kaptcha.border", "yes");
		Properties.put("kaptcha.border.color", "105,179,90");
		Properties.put("kaptcha.textproducer.font.color", "blue");
		Properties.put("kaptcha.textproducer.font.size", "45");
		Properties.put("kaptcha.image.width", "200");
		Properties.put("kaptcha.image.height", "50");
		Properties.put("kaptcha.textproducer.char.length", "4");
		Properties.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		Config Config= new Config(Properties);
		DefaultKaptcha.setConfig(Config);
		return DefaultKaptcha;
		
		
	}

	@Bean
	public Slf4jLogFilter getSlf4jLogFilter() {
		Slf4jLogFilter slf = new Slf4jLogFilter();
		slf.setConnectionLogEnabled(true);
		slf.setStatementLogEnabled(true);
		slf.setResultSetLogEnabled(true);
		slf.setStatementExecutableSqlLogEnable(true);
		return slf;
	}


}
