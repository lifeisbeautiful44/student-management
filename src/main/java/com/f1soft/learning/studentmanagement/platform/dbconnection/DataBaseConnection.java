package com.f1soft.learning.studentmanagement.platform.dbconnection;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static DataBaseConnection instance = null;

    private String url = "jdbc:mysql://localhost:3306/student_management";
    private String userName = "root";
    private String password = "#f1soft44";

    private static Connection con;

    private DataBaseConnection()  {
        try {
           con = DriverManager.getConnection(this.url,this.userName,this.password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database");
        }

    }

    public static DataBaseConnection getInstance()  {

        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    instance = new DataBaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection()
    {
        return con;
    }


}
