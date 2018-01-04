package Server.Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerSocketHandler {

    public static void main(String args[]) throws IOException, SQLException {
            UserManager userManager = new UserManager();
        try {
            UserManager.getAllUsers();
            userManager.saveUsers(new CollectionOfUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
            String inputCommand, output;
            ServerSocket s1 = new ServerSocket(9999);
            Boolean sendLoginInfo = true;
        while(true) {
            SqlCmds sqlCmds = new SqlCmds();
            Connection connection = UserManager.conn;
            Socket ss = s1.accept();
            if(sendLoginInfo) {
                Statement stmt = connection.createStatement();
                String sql = "SELECT email, password FROM [User]";
                ResultSet rs = stmt.executeQuery(sql);
                ArrayList<String> email_list = new ArrayList<>();
                ArrayList<String> password_list = new ArrayList<>();
                while (rs.next()) {
                    //Retrieve by column name
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    email_list.add(email);
                    password_list.add(password);
                }
                rs.close();
                ObjectOutputStream outputStream = new ObjectOutputStream(ss.getOutputStream());
                outputStream.writeObject(email_list);
                outputStream.writeObject(password_list);
                sendLoginInfo =false;
            }
            Scanner sc = new Scanner(ss.getInputStream());
            inputCommand = sc.nextLine();
            if(inputCommand.equals("1")){
                String var1 = sqlCmds.SignOnCourse(1,1);
                PreparedStatement toPost = connection.prepareStatement(var1);
                toPost.executeUpdate();
                output ="Your are now registred on the course" ;
                PrintStream p = new PrintStream(ss.getOutputStream());
                p.println(output);
            }
            if(inputCommand.equals("2")){
                int userID = 0;
                int courseID = 0 ;
                String var2 = sqlCmds.RemoveCourseFromUser(userID,courseID);
                PreparedStatement toPost = connection.prepareStatement(var2);
                toPost.executeUpdate();
                output = "You have now removed Course+";
                PrintStream p = new PrintStream(ss.getOutputStream());
                p.println(output);
            }
            else{
                output = "Error";
                PrintStream p = new PrintStream(ss.getOutputStream());
                p.println(output);
            }

        }

    }


}
