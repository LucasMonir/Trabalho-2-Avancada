package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static private Connection connection = null;
    static private String url = "";
    static private String username = "";
    static private String password = "";
    static private String dbdriver = "";

    static public void setConfig(String iurl, String uname, String pass, String dbdriv) {
        url = iurl;
        username = uname;
        password = pass;
        dbdriver = dbdriv;
    }

    static public Connection getConnection() {
        if (connection == null) {
            try {

                Class.forName(dbdriver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }
}
