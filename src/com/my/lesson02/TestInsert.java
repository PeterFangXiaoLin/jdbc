package com.my.lesson02;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT INTO users(id, `name`, `PASSWORD`, `email`, `birthday`) VALUES(4, '123', '123456', '121@qq.com', '2024-01-01')";

            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, statement, resultSet);
        }
    }
}
