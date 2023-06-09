package Model.connection_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MauawarDatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/mauawardb";
    private static final String user = "root";
    private static final String password = "MySql";

    private static Connection conn;

    public static Connection get_connection_database_mauawar(){

        try{
            if(conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}