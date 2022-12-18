package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/cinema?useTimeZone=true&serverTimeZone=UTC", "root", "password");

        System.out.println("Hello World!");
        System.out.println("connection successful");

        connection.close();
    }
}
