package com.my.lesson05;

import com.my.lesson05.utils.JdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestC3P0 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "insert into users(id, name, password, email, birthday) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "王五");
            preparedStatement.setString(3, "123");
            preparedStatement.setString(4, "120@qq.com");
            preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, null);
        }
    }
}
