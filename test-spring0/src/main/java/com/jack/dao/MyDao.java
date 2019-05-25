package com.jack.dao;

import com.jack.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("dao")
@Service
public class MyDao{
	/*@Autowired
	private MyService myService;*/

	@Autowired
	private Dao daoAImpl;

	public void show() {
		daoAImpl.query();
	}
}
