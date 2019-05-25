package com.jack.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary//这个注解修饰的类，如果容器中有两个Dao类型的Bean，那么使用类型注入的时候，会选择@Primary注解的这个Bean。
public class DaoAImpl implements Dao {
	@Override
	public void query() {
		System.out.println("DaoAImpl ... query ....");
	}
}
