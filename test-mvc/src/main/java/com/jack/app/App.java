package com.jack.app;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class App {
	public static void main(String[] args) {
		try {
			SpringApplicationJack.run();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
