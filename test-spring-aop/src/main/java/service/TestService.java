package service;

import annotation.JackLog;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@JackLog("hello world")
	public void save(String id) {
		System.out.println("调用dao进行数据库保存操作...");
	}
}
