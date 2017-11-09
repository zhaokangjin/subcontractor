package com.accenture.subcontractor.job;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EnableCaching
@ComponentScan(basePackages={"com.accenture.subcontractor.job"})
@MapperScan("com.accenture.subcontractor.job.persistence")
@EnableCaching
public class SubcontractorApp {
	private final static Logger logger = LoggerFactory.getLogger(SubcontractorApp.class);
	/**   
	 * @Title: main   
	 * @Description: TODO  格式要求，无实际作用
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("SubcontractorApp starting...");
		SpringApplication.run(SubcontractorApp.class, args);
	}
	
}
