package Adapters.connection_database.connection_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MauawarDatabaseConnection {

    private static final String url = "jdbc:mysql://root:IbN9jYBYJoMJk4ASq0W8@containers-us-west-134.railway.app:7863/railway";
    private static final String user = "root";
    private static final String password = "IbN9jYBYJoMJk4ASq0W8";

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