package com.remcarpediem.demo.persistent.base;

import java.sql.*;
import java.util.Properties;

public class BaseJDBCTest {
    static final String  URL = "jdbc:mysql://114.67.98.210:3306/sk-admin?useSSL=false&serverTimezone=UTC";
    static final String USER_NAME ="root";
    static final String PASSWORD = "root_test";

    public static void main(String[] args) {
        getDataConnectionTest();
    }


    public static void insertDataConnectionTest() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.加载类，并注册驱动器（Driver会注册到DriverManager中）

            //加载Oracle数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //2.根据特定的URL，返回可以接受此URL的数据库驱动对象
            Driver driver = DriverManager.getDriver(URL);
            Properties props = new Properties();
            props.put("user", USER_NAME);
            props.put("password", PASSWORD);

            //3.使用数据库驱动创建数据库连接Connection会话
            connection = driver.connect(URL, props);
            connection.setAutoCommit(false);

            //4.获得Statement对象
            statement = connection.createStatement();
            //5.执行 sql语句，返回结果
            statement.execute("INSERT INTO activity (activity_id, activity_name, product_id, start_time, end_time, total, status, sec_speed, buy_limit, buy_rate) VALUES (1, '香蕉大甩卖', 1, 530871061, 530872061, 20, 0, 1, 1, 0.20);");
            statement.getConnection().commit();

            PreparedStatement pstmt = null;
            try {
                String SQL = "Update activity SET activity_name = ? WHERE activity_id = ?";
                pstmt = connection.prepareStatement(SQL);
                pstmt.setString(1, "测试");
                pstmt.setInt(2, 1);
                pstmt.executeUpdate();
            }
            catch (SQLException e) {
            }
            finally {
                pstmt.close();
            }

            //7.关闭链接，释放资源
        } catch (ClassNotFoundException e) {
            System.out.println("加载JDBC类失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //使用完成后管理链接，释放资源，释放顺序应该是： ResultSet ->Statement ->Connection
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getDataConnectionTest(){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //1.加载类，并注册驱动器（Driver会注册到DriverManager中）

            //加载Oracle数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //2.根据特定的URL，返回可以接受此URL的数据库驱动对象
            Driver driver = DriverManager.getDriver(URL);
            Properties props = new Properties();
            props.put("user", USER_NAME);
            props.put("password", PASSWORD);

            //3.使用数据库驱动创建数据库连接Connection会话
            connection = driver.connect(URL, props);

            //4.获得Statement对象
            statement = connection.createStatement();
            //5.执行 sql语句，返回结果
            resultSet = statement.executeQuery("select * from activity");
            //6.处理结果，取出数据
            while(resultSet.next())
            {
                System.out.println(resultSet.getString(2));
            }

            //7.关闭链接，释放资源
        } catch (ClassNotFoundException e) {
            System.out.println("加载JDBC类失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //使用完成后管理链接，释放资源，释放顺序应该是： ResultSet ->Statement ->Connection
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
