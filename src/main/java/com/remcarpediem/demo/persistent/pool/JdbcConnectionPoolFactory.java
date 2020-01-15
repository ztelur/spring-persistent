package com.remcarpediem.demo.persistent.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class JdbcConnectionPoolFactory extends BasePooledObjectFactory<Connection> {

    private Driver driver;
    static final String  URL = "jdbc:mysql://114.67.98.210:3306/sk-admin?useSSL=false&serverTimezone=UTC";
    static final String USER_NAME ="root";
    static final String PASSWORD = "root_test";


    public JdbcConnectionPoolFactory(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Connection create() throws Exception {
        Properties props = new Properties();
        props.put("user", USER_NAME);
        props.put("password", PASSWORD);
        Connection connection = driver.connect(URL, props);
        connection.setAutoCommit(false);
        return connection;
    }

    @Override
    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject<>(connection);
    }

    @Override
    public PooledObject<Connection> makeObject() throws Exception {
        return super.makeObject();
    }

    @Override
    public void destroyObject(PooledObject<Connection> p) throws Exception {
        super.destroyObject(p);
    }

    @Override
    public boolean validateObject(PooledObject<Connection> p) {
        return super.validateObject(p);
    }

    @Override
    public void activateObject(PooledObject<Connection> p) throws Exception {
        super.activateObject(p);
    }

    @Override
    public void passivateObject(PooledObject<Connection> p) throws Exception {
        p.getObject().setAutoCommit(true);
    }
}
