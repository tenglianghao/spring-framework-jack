import com.jack.config.AutowiredTestConfig;
import com.jack.config.CycleAutowiredMainConfig;
import com.jack.config.LiteMainConfig;
import com.jack.config.MainConfig;
import com.jack.service.MyService;
import com.jack.service.OrderService;
import com.jack.service.SingletonService;
import com.jack.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServiceTest {

	@Test
	public void testScanBeanDefinition() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfig.class, LiteMainConfig.class);
	}

	@Test
	public void testInit() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println(context.getBean(MyService.class));
		context.close();
	}

	@Test
	public void testCycleAutowired() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(CycleAutowiredMainConfig.class);
		context.getBean(OrderService.class);
	}

	@Test
	public void testScope() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(CycleAutowiredMainConfig.class);
		SingletonService service = context.getBean(SingletonService.class);
		service.getDaoHashCode();
		service = context.getBean(SingletonService.class);
		service.getDaoHashCode();
	}

	@Test
	public void testAutowired() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AutowiredTestConfig.class);
	}
}
