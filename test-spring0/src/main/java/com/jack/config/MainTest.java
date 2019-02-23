package com.jack.config;

import com.jack.config.MainConfig;
import com.jack.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfig.class);
		/*context.register(MyService.class);
		context.refresh();*/
		//context.addBeanFactoryPostProcessor();
		MyService bean = context.getBean(MyService.class);
	}
}
