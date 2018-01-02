package Nawfall_src.model;

import Nawfall_src.Database.Connection_to_db;
import Server.Model.Courses;
import Server.Model.User;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class UserManager {
    public static CollectionOfUsers getAllUsers() throws Exception {
        CollectionOfUsers users = null;
        try {
            Connection conn = Connection_to_db.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM [User]";
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                int id = result.getInt("ID");
                String name = result.getString("name");
                String username = result.getString("username");
                String password = result.getString("password");
                String email = result.getString("email");
                Boolean is_teacher = result.getBoolean("is_teacher");
                Boolean is_admin = result.getBoolean("is_admin");
                User user = new User(id,name,username,password,email,is_teacher,is_admin);
            }
            result.close();

            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (CollectionOfUsers) ;
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return users;
    }

    public static void saveUsers(CollectionOfUsers users) throws Exception {
        try {
            Connection conn = Connection_to_db.getConnection();
            Statement stmt = conn.createStatement();

            int id = User.getuserId();
            String name = User.getName();
            String
            String sql ="INSERT INTO [User] VALUES ";
            FileOutputStream fileOut =
                    new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

}
