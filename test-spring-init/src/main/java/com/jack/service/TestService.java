package com.jack.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class TestService implements InitializingBean, DisposableBean {

	public TestService() {
		System.out.println("TestSesrvice...构造方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("TestService...InitializingBean...afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("TestService...DisposableBean...destroy");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("TestService...@PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("TestService...@preDestroy");
	}

	public void init() {
		System.out.println("TestService...init");
	}

	public void destroy2() {
		System.out.println("TestService...destroy");
	}
}
