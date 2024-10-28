package com.my.lesson04;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false); // 开启事务

            String sql = "update account set money=money-100 where name = 'A'";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            String sql2 = "update account set money=money+100 where name='B'";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            connection.commit();
            System.out.println("成功");
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            JdbcUtils.release(connection, preparedStatement, null);
        }
    }
}
