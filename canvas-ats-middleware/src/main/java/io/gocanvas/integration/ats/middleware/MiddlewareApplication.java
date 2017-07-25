package io.gocanvas.integration.ats.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import io.gocanvas.integration.ats.middleware.factory.MiddlewareServiceFactory;

/**
 * @author Prodapt Solutions
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io.gocanvas.integration.ats.middleware.*" })
public class MiddlewareApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MiddlewareApplication.class, args);
		try {
			context.getBean(MiddlewareServiceFactory.class).getMiddlewareService(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME).refreshCacheData(MiddlewareConstants.CANDIDATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			context.getBean(MiddlewareServiceFactory.class).getMiddlewareService(MiddlewareConstants.GREENHOUSEMIDDLEWARENAME).refreshCacheData(MiddlewareConstants.JOB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
		PropertySourcesPlaceholderConfigurer obj = new PropertySourcesPlaceholderConfigurer();
		return obj;
	}
	
	
	

}
