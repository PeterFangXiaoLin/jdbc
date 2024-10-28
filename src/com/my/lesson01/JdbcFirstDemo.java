package com.my.lesson01;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 用户信息和 url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";

        // 3. Connection 代表数据库对象
        Connection connection = DriverManager.getConnection(url, user, password);

        // 4. 执行 sql 的对象
        Statement statement = connection.createStatement();

        // 5. 执行 sql
        String sql = "select * from users";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("NAME"));
            System.out.println("pwd=" + resultSet.getObject("PASSWORD"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birth=" + resultSet.getObject("birthday"));
            System.out.println("==================================================");
        }

        // 6. 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
