package com.jack.cglib;

public class TestCglib {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		UserDao proxyDao = (UserDao) new ProxyFactory(userDao).getProxyInstance();
		proxyDao.saveUser();
	}
}
