package io.github.kuyer.logmonitor.dao;

import io.github.kuyer.logmonitor.BootApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BootApplication.class)
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test() {
		Long time = System.currentTimeMillis();
		userDao.insert("1", "rory1", "北京", time, time);
	}

}
