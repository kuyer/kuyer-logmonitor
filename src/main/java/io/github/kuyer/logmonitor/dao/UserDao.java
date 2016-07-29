package io.github.kuyer.logmonitor.dao;

public interface UserDao {
	
	public void insert(String id, String account, String alias, Long logind, Long registed);

}
