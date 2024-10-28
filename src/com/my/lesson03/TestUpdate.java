package com.my.lesson03;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtils.getConnection();

            String sql = "update users set name=? where id=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "张三");
            preparedStatement.setInt(2, 1);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, preparedStatement, null);
        }
    }
}
