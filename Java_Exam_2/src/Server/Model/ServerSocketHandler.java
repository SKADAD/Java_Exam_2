package Server.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerSocketHandler {

    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
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
            Socket serverSocket = s1.accept();
            if(sendLoginInfo) {
                Statement stmt = connection.createStatement();
                String sql = "SELECT ID, email, password FROM [User]";
                ResultSet rs = stmt.executeQuery(sql);
                ArrayList<Integer> id_list = new ArrayList<>();
                ArrayList<String> email_list = new ArrayList<>();
                ArrayList<String> password_list = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    id_list.add(id);
                    email_list.add(email);
                    password_list.add(password);
                }
                rs.close();
                ObjectOutputStream outputStream = new ObjectOutputStream(serverSocket.getOutputStream());
                outputStream.writeObject(id_list);
                outputStream.writeObject(email_list);
                outputStream.writeObject(password_list);
                sendLoginInfo =false;
            }

            ObjectInputStream ob = new ObjectInputStream(serverSocket.getInputStream());
            ArrayList<Integer> toTheServer = (ArrayList<Integer>) ob.readObject();
            int choice = toTheServer.get(0);
            int id = toTheServer.get(1);
            if(choice==1){
                ArrayList<Integer> id_list = new ArrayList<>();
                ArrayList<String> name_list = new ArrayList<>();
                ArrayList<Integer> teacher_list = new ArrayList<>();
                ArrayList[] courses = new ArrayList[3];
                String var1 = sqlCmds.ViewAllMyCourses(id);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(var1);
                while(resultSet.next()){
                    int course_id = resultSet.getInt("ID");
                    String course_name = resultSet.getString("name");
                    int teacher_id = resultSet.getInt("teacher_ID");
                    id_list.add(course_id);
                    name_list.add(course_name);
                    teacher_list.add(teacher_id);
                }
                courses[0] = id_list;
                courses[1] = name_list;
                courses[2] = teacher_list;
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverSocket.getOutputStream());
                objectOutputStream.writeObject(courses);
                //PrintStream p = new PrintStream(serverSocket.getOutputStream());
                //p.println(resultSet);
            }
            else if(choice==2){
                int userID = 0;
                int courseID = 0 ;
                String var2 = sqlCmds.RemoveCourseFromUser(userID,courseID);
                PreparedStatement toPost = connection.prepareStatement(var2);
                toPost.executeUpdate();
                output = "You have now removed Course+";
                PrintStream p = new PrintStream(serverSocket.getOutputStream());
                p.println(output);
            }
            else{
                output = "Error";
                PrintStream p = new PrintStream(serverSocket.getOutputStream());
                p.println(output);
            }
        }
    }
}
