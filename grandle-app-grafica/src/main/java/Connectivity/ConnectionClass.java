package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    private static String dbName = "DB";
    private static String url = "jdbc:hsqldb:file:LOCAL";
    private static String user = "user";
    private static String password = "parola";
    private static String driver = "org.hsqldb.jdbc.JDBCDriver";

    public Connection getConnection()
    {

        Connection connection = null ;
        try {

            //Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Class.forName(driver);


            connection = DriverManager.getConnection(url + dbName ,user,password);
            System.out.println("connected");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
