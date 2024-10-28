package com.my.lesson02;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "update users set name='blue', email='12345@qq.com' where id=1";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, statement, null);
        }
    }
}
