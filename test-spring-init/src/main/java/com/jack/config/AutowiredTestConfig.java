package com.jack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.jack.dao","com.jack.service"})
public class AutowiredTestConfig {

	@Bean
	public String str1() {
		return "hello world";
	}

	@Bean
	@Primary
	public String str2() {
		return "hi jack";
	}

}
