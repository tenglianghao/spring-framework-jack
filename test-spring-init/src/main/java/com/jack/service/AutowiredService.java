package com.jack.service;

import com.jack.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutowiredService {

	@Autowired
	private IDao dao;
}
