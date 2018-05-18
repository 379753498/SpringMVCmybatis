package com.javen.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javen.interceptor.imp.Mvcinterceptor;
import com.javen.interceptor.imp.TokenInterceptor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan( "com.javen.controller" )
public class WebConfig  extends WebMvcConfigurerAdapter{

		@Bean
		public ViewResolver viewResolver(){
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/page/");
	        resolver.setSuffix(".html");
	        return resolver;
	    }
		
		@Bean(name="multipartResolver")
		protected CommonsMultipartResolver MultipartResolver() {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
			//multipartResolver.setUploadTempDir(new FileSystemResource("/tmp"));//可以不设置
			multipartResolver.setMaxUploadSize(2097152);//2M
			multipartResolver.setMaxInMemorySize(0);
			multipartResolver.setDefaultEncoding("UTF-8");
			return multipartResolver;
		}
		
		
		  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		        configurer.enable();
		   }
		  
		  public void addInterceptors(InterceptorRegistry registry) {  
		        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");  
		        registry.addInterceptor(new Mvcinterceptor()).addPathPatterns("/**");  
		    }  
}
