package test;

import config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TestService;

public class TestAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AopConfig.class);
		TestService service = context.getBean(TestService.class);
		System.out.println(service);
		service.save("aaa");
	}
}
