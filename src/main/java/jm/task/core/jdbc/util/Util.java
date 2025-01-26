package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

//    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String JDBC_USERNAME = "admin";
    private static final String JDBC_PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
//            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME,JDBC_PASSWORD);
//            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected to error");
        }
        return connection;
    }
}
