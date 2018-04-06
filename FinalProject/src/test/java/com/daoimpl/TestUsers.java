/**
 * 
 */
package com.daoimpl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.daoapi.UsersDao;
import com.entities.Users;

/**
 * @author diana
 *
 */
public class TestUsers {

	private static ClassPathXmlApplicationContext context;
	private static UsersDao usersDao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("context.xml");
		usersDao = (UsersDao) context.getBean("UsersDao");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		context.close();

	}

	@Test
	public void test() {
		Users newUser = new Users();
		newUser.setUser_name("Hello");
		newUser.setEmail("allam@gmail.com");
		usersDao.saveOrUpdate(newUser);

	}

}
