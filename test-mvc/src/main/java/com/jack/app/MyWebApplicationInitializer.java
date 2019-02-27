package com.jack.app;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletException;

/**
 * Servlet容器规范，在启动容器的时候，会调用Web项目的 WebApplicationInitializer 回调方法。
 * 注意，只有Web项目才有此待遇。
 * 一般情况下在这个方法中初始化springIOC环境
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
		System.out.println("---------------------");
	}
}
