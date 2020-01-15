package com.remcarpediem.demo.persistent;

import com.remcarpediem.demo.persistent.pool.JdbcConnectionPoolFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersistentApplicationTests {

	private GenericObjectPool<Connection> pool;
	static final String  URL = "jdbc:mysql://114.67.98.210:3306/sk-admin?useSSL=false&serverTimezone=UTC";

	@Before
	public void init() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Driver driver = DriverManager.getDriver(URL);
		pool = new GenericObjectPool<Connection>(new JdbcConnectionPoolFactory(driver));
	}

	@Test
	public void contextLoads() throws Exception {
		Connection connection = pool.borrowObject();
		//4.获得Statement对象
		Statement statement = connection.createStatement();
		//5.执行 sql语句，返回结果
		statement.execute("INSERT INTO activity (activity_id, activity_name, product_id, start_time, end_time, total, status, sec_speed, buy_limit, buy_rate) VALUES (1, '香蕉大甩卖', 1, 530871061, 530872061, 20, 0, 1, 1, 0.20);");
		statement.getConnection().commit();
		statement.close();
		pool.returnObject(connection);
	}

}
