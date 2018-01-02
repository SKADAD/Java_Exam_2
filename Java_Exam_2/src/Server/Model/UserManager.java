package Server.Model;

import Nawfall_src.Database.Connection_to_db;

import java.sql.*;
import java.util.ArrayList;

public class UserManager {

    public void getAllUsers() throws Exception {
        Connection conn = Connection_to_db.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM [User]";
        ResultSet result = stmt.executeQuery(sql);
        CollectionOfUsers users = new CollectionOfUsers();
        while(result.next()){
            int id = result.getInt("ID");
            String name = result.getString("name");
            String username = result.getString("username");
            String password = result.getString("password");
            String email = result.getString("email");
            Boolean is_teacher = result.getBoolean("is_teacher");
            Boolean is_admin = result.getBoolean("is_admin");
            User user = new User(id,name,username,password,email,is_teacher,is_admin);
            users.addUser(user);
        } result.close();
    }

    public void saveUsers(CollectionOfUsers collection) throws Exception{
        ArrayList<User> users = collection.users;
        Connection conn = Connection_to_db.getConnection();
        for(int i = 0; i<users.size(); i++){
            int id = users.get(i).getUserId();
            String name = users.get(i).getName();
            String username = users.get(i).getUsername();
            String password = users.get(i).getPassword();
            String email = users.get(i).getEmail();
            Boolean is_teacher = users.get(i).getTeacher();
            Boolean is_admin = users.get(i).getAdmin();
            PreparedStatement posted = conn.prepareStatement("INSERT INTO [User] VALUES('"+id+"','"+name+"','"+username+"','"+password+"','"+email+"','"+is_teacher+"','"+is_admin+"')");
            posted.executeUpdate();
        }
    }
}
