package com.cg.inotes.DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static DBContext instance;
    private Connection connection;
    private DBContext(){
        String jdbcURL = "jdbc:mysql://localhost:3306/iNotes";
        String username = "root";
        String password = "0848101999";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static DBContext getInstance() {
        // Phương thức getInstance() sẽ trả về một thể hiện duy nhất của DBCOntext
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }

    public Connection getConnection() {
        // Phương thức getConnection() trả về kết nối cơ sở dữ liệu
        return connection;
    }
    public void closeConnection() {
        // Phương thức closeConnection() đảm bảo kết nối cơ sở dữ liệu đã được đóng
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
