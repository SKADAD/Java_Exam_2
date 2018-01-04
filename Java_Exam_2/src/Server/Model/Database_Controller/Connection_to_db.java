package Server.Model.Database_Controller;


import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_to_db {

    public static Connection getConnection() throws Exception{
        try{
            String url = "localhost\\DESKTOP-O2C8F9Q";
            int port = 1433;
            String username = "Peter";
            String password = "qwe123";
            String database = "JavaExam2";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver loaded");
            String jdbcUrl = "jdbc:sqlserver://"+url+":"+port+";user="+username+";password="+password+";databaseName="+database+"";
            Connection con = DriverManager.getConnection(jdbcUrl);
            System.out.println("It worked");
            return con;

        }catch (Exception e){System.out.println(e);}
        return null;
    }
}
