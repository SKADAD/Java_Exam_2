package Server.Model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private Boolean isTeacher;
    private Boolean isAdmin;



    public User(int userId, String name, String username, String password, String email, Boolean is_teacher, Boolean is_admin){
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isTeacher = false;
        this.isAdmin = false;
    }

    public User(int userId, String name, String username, String password, String email, ArrayList<String> courses, Boolean isTeacher, Boolean isAdmin){
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isTeacher = isTeacher;
        this.isAdmin = isAdmin;
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
