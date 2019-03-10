package com.jack.service;

import com.jack.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class AutowiredService {
	private final IDao dao;

	//@Autowired
	public AutowiredService(IDao dao) {
		this.dao = dao;
	}

	@Autowired
	public AutowiredService(IDao dao, String string) {
		System.out.println("------" + string + "-----");
		this.dao = dao;
	}
}
