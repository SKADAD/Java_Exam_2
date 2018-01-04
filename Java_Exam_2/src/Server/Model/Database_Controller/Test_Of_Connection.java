package Server.Model.Database_Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_Of_Connection {
    public static void main(String[] args) throws Exception {
        Connection conn = Connection_to_db.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT username, password FROM [User]";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            //Retrieve by column name
            String username = rs.getString("username");
            String password = rs.getString("password");
            //Display values
            System.out.print("Username: " + username);
            System.out.print("Password: " + password);
        }
        rs.close();
    }
}
