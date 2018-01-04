package Server.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoursesTest {
    Courses course;
    @BeforeEach
    void setUp() {
        course = new Courses(10,"El-Lära",1);
    }

    @Test
    void getCourseID() {
        int answer = course.getCourseID();
        assertEquals(10,answer);
    }

    @Test
    void getCourseName() {
        String name = course.getCourseName();
        assertEquals("El-Lära",name);
    }

    @Test
    void getCourseTeacher() {
        int teacher = course.getCourseTeacher();
        assertEquals(1,teacher);
    }
}