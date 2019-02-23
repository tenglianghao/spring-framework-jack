package com.jack.app;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletException;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
		System.out.println("---------------------");
	}
}
