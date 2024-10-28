package com.my.lesson03;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtils.getConnection();

            String sql = "insert into users(id, name, password, email, birthday) values(?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "张三");
            preparedStatement.setString(3, "123456");
            preparedStatement.setString(4, "123@qq.com");
            preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, preparedStatement, null);
        }
    }
}
