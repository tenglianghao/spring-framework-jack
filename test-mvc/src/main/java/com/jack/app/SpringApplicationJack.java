package com.jack.app;

import com.jack.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.File;

public class SpringApplicationJack {

	public static void run() throws ServletException, LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8090);

		File base = new File(System.getProperty("java.io.tmpdir"));

		// 初始化spring环境
		AnnotationConfigWebApplicationContext webApplicationContext
				= new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(AppConfig.class);
		webApplicationContext.refresh();
		/*
		addWebapp表示这是一个Web项目,tomcat启动的时候会为web做一些准备工作
		例如回调 WebApplicationInitializer 的 onStartup()方法，以及加载 org.apache.jasper.servlet.JspServlet
		如果没有添加jsp的依赖，则会报错。
		第一个参数：tomcat的访问路径
		第二个参数：项目的web目录
		这里不能使用addWebapp()，springboot也没这样使用
		Context webapp = tomcat.addWebapp("/", base.getAbsolutePath());
		 */
		Context context = tomcat.addContext("/index", base.getAbsolutePath());

		// 初始化springweb环境
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		tomcat.addServlet(context, "aa", dispatcherServlet).setLoadOnStartup(0);
		context.addServletMapping("/","aa");

		tomcat.start();
		tomcat.getServer().await();
	}
}
