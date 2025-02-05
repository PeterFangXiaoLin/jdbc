package com.my.lesson02;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "delete from users where id = 4";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, statement, null);
        }
    }
}
