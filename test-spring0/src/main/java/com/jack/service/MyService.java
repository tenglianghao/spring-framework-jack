package com.jack.service;

import com.jack.dao.Dao;
import com.jack.dao.MyDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;
//根据不同的条件从容器里面获取不同的bean
@Service("service")
public class MyService implements ApplicationContextAware {

	private ApplicationContext context; // 从ioc容器中获取

	@Autowired
	private Map<String, Dao> map; // 可使用一个map进行接收

	public void query(String name) {
		if (name.equals("A")) {
			map.get("daoAImpl").query();
		} else if (name.equals("B")) {
			map.get("daoBImpl").query();
		} else {
			System.out.println("there has no suitable impl ");
		}
	}

	public void query2(String name) {
		if (name.equals("A")) {
			((Dao)context.getBean("daoAImpl")).query();
		} else if (name.equals("B")) {
			((Dao)context.getBean("daoBImpl")).query();
		} else {
			System.out.println("there has no suitable impl ");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
