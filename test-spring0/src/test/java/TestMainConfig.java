import com.jack.config.AutoAwareMainConfig;
import com.jack.config.FactoryBeanConfig;
import com.jack.config.MainConfig;
import com.jack.config.SimpleMainConfig;
import com.jack.dao.MyDao;
import com.jack.service.MyService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMainConfig {

	@Test
	public void testFactoryBean() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		Object bean1 = context.getBean("myFactoryBean");
		System.out.println("名字为myFactoryBean的bean是" + bean1.getClass());
		Object bean2 = context.getBean("&myFactoryBean");
		System.out.println("名字为&myFactoryBean的bean是" + bean2.getClass());
	}

	@Test
	public void testMain() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfig.class);

	}


	@Test
	public void testIOC() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfig.class);
		MyService bean = context.getBean(MyService.class);
		//bean.query("A");
		bean.query2("B");

	}

	@Test
	public void testImportAware() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AutoAwareMainConfig.class);
	}

	// 普通测试类
	@Test
	public void testSimpleIoc() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SimpleMainConfig.class);
	}

	@Test
	public void testAutowired() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SimpleMainConfig.class);
		MyDao bean = context.getBean(MyDao.class);
		bean.show();
	}

}
