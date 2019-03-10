package com.jack.config;

import com.jack.service.OrderService;
import org.springframework.context.annotation.Bean;

/**
 * 可以不用加@Configuration注解
 * 只要有下面五个注解之一就可以视为配置类：
 * @Component
 * @ComponentScan
 * @Import
 * @ImportResource
 * @Bean
 */
public class LiteMainConfig {

	@Bean
	public OrderService orderService() {
		return new OrderService();
	}
}
