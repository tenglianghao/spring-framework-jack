package com.jack.config;

import com.jack.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.jack.service"})
public class MainConfig {

	@Bean(initMethod = "init",destroyMethod = "destroy2")
	public TestService testService() {
		return new TestService();
	}

}
