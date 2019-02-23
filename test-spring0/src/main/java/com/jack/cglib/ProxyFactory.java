package com.jack.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory {
	// 目标对象
	public Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		// 工具类
		Enhancer enhancer = new Enhancer();
		// 把目标类设置成代理类的父类
		enhancer.setSuperclass(target.getClass());
		// 设置回调函数，代理类执行目标方法时会走这里
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("执行目标方法之前");
				method.invoke(target, objects);
				System.out.println("执行目标方法之后");
				return null;
			}
		});
		return enhancer.create();
	}
}
