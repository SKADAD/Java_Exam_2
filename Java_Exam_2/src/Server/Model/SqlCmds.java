package Server.Model;

public class SqlCmds {
    private String sqlCmd;
    public String SignOnCourse(int userID, int courseID){
        sqlCmd = "INSERT INTO connector values('"+userID+"','"+courseID+"')";
        return sqlCmd;
    }

    public String RemoveCourseFromUser(int userID, int courseID){
        sqlCmd = "DELETE FROM connector WHERE user_ID ='"+userID+"' AND course_ID='"+courseID+"'";
        return sqlCmd;
    }

    public String RemoveCourse(int courseID){
        sqlCmd = "DELETE FROM Course WHERE course_ID='"+courseID+"'";
        return sqlCmd;
    }

    public String ViemAllCourses(){
        sqlCmd = "SELECT * FROM Courses";
        return sqlCmd;
    }

    public String ViewAllMyCourses(int userID){
        sqlCmd = "SELECT * FROM Course INNER JOIN connector ON Course.ID = connector.course_ID WHERE connector.user_ID ='"+userID+"'";
        return sqlCmd;
    }

    public String AddNewCourses(int id, String name, int teacher_ID){
        sqlCmd = "INSERT INTO Courses VALUES('"+id+"','"+name+"','"+teacher_ID+"')";
        return sqlCmd;
    }
}
