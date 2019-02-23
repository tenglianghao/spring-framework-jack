package com.jack.factoryBean;

import com.jack.service.MyService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<MyService> {
	@Override
	public MyService getObject() throws Exception {
		//return new MyService("aaa");
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return MyService.class;
	}

	@Override
	public boolean isSingleton() {
		// 设置返回的Bean是否为单例
		return true;
	}
}
