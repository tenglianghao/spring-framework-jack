package com.jack.service;

import com.jack.dao.IDao;
import com.sun.xml.internal.bind.annotation.XmlLocation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

//@Service
public abstract class SingletonService{

	public String getDaoHashCode() {
		IDao dao = getDao();
		System.out.println(String.valueOf(dao.hashCode()));
		return null;
	}


	@Lookup
	protected abstract IDao getDao();

}
