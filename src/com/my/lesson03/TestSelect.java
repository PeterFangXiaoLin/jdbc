package com.my.lesson03;

import com.my.lesson02.utils.JdbcUtils;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();

            String sql = "select * from users where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 1);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String email = resultSet.getString(4);
                Date date = resultSet.getDate(5);
                System.out.println(id + " " + name + " " + password + " " + email + " " + date);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(connection, preparedStatement, resultSet);
        }
    }
}
