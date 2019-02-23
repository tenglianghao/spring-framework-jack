package dao;

public class UserDaoImpl implements UserDao {
	@Override
	public String query(String name, Integer age) {
		System.out.println("UserDaoImpl... query...");
		return "查询条件: name = " + name +", age = " + age ;
	}

	@Override
	public void query() {
		System.out.println("...");
	}
}
