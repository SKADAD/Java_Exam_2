package Server.Model;

public class Teacher extends User {

    private int teacherId;
    private String course;

    public Teacher(String name, String username, String password, int teacherId, String course){
        super(name, username, password);
        this.course = course;
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
