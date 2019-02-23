package dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TestDao {

	public List<Map<String, Object>> query() {
		return new ArrayList<>();
	}
}
