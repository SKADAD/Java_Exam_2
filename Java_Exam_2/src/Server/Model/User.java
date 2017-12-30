package Server.Model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private ArrayList<String> courses;
    private Boolean isTeacher;
    private Boolean isAdmin;



    public User(int userId,String name, String username, String password, String email, ArrayList<String> courses){
        this.userId = userId;
        this.name = name;
        this. username = username;
        this.password = password;
        this.email = email;
        this.courses = courses;
        this.isTeacher = false;
        this.isAdmin = false;


    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public Boolean getTeacher() {
        return isTeacher;
    }

    public void setTeacher(Boolean teacher) {
        isTeacher = teacher;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}


