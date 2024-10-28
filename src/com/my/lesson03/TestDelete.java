package com.my.lesson03;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtils.getConnection();

            String sql = "delete from users where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 4);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, preparedStatement, null);
        }
    }
}
