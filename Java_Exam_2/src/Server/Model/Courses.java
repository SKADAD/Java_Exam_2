package Server.Model;


public class Courses {

    private int courseID;
    private String courseName;
    private String courseTeacher;

    public Course(int courseID, String courseName, String courseTeacher){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;


    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public java.lang.String getCourseName() {
        return courseName;
    }

    public void setCourseName(java.lang.String courseName) {
        this.courseName = courseName;
    }

    public java.lang.String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(java.lang.String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
}
