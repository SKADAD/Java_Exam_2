package Server.Model;


public class Courses {

    private int courseID;
    private String courseName;
    private int courseTeacher;

    public Courses(int courseID, String courseName, int courseTeacher){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;

    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseTeacher() {
        return courseTeacher;
    }

}