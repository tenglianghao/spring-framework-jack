package aspect;

import annotation.JackLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
/**
 * 加入 @Aspect 注解表明这个类是一个切面
 */
public class LogAspect {


	/**
	 * 定义切点，使用切入点表达式
	 * 它表明需要增强哪些方法
	 * <public> 指对所有的公用方法起作用，非必选
	 * 第一个 * 匹配所有的返回值类型
	 * 第二个 * 匹配service包下的所有类
	 * 第三个 * 匹配类中的所有方法
	 * .. 匹配所有的参数个数和类型
	 */
	@Pointcut("execution(public * service.TestService.save(String))")
	public void pointcut() {

	}

	@Pointcut("execution(public * dao.TestDao.*(..))")
	public void pointcut2() {

	}


	@Around("@annotation(jackLog)")
	public void around(ProceedingJoinPoint proceedingJoinPoint, JackLog jackLog) throws Throwable {
		Object[] args = proceedingJoinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("参数为：" + String.valueOf(arg));
		}
		System.out.println("注解的参数为：" + jackLog.value());
		proceedingJoinPoint.proceed();
	}

}
