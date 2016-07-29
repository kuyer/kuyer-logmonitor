package io.github.kuyer.logmonitor.dao.impl;

import io.github.kuyer.logmonitor.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(String id, String account, String alias, Long logind, Long registed) {
		jdbcTemplate.update("insert into t_user (c_id, c_account, c_alias, c_logind, c_registed) values (?, ?, ?, ?, ?)", id, account, alias, logind, registed);
	}
	
}
