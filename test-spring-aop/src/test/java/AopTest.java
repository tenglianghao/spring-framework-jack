import config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TestService;

public class AopTest {


	@Test
	public void testAspectJ() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AopConfig.class);
		TestService service = context.getBean(TestService.class);
		service.save();
	}
}
