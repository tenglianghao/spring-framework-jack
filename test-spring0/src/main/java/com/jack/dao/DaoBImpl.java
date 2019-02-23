package com.jack.dao;

import org.springframework.stereotype.Component;

//@Component
public class DaoBImpl implements Dao {
	@Override
	public void query() {
		System.out.println("DaoBImpl ... query ....");
	}
}
