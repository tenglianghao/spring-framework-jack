package com.jack.test;

import com.jack.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoggerTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfig.class);

	}
}
