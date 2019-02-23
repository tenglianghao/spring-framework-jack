package com.jack.dao;

import com.jack.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dao")
public class MyDao{
	/*@Autowired
	private MyService myService;*/

	public void query() {
		System.out.println("mydao...query...");
	}
}
