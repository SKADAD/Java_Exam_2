package Server.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    @BeforeEach
    void setUp() {
        user = new User(1,"Peter","peter123","peter123","peter@peter.se",false,true);
    }

    @Test
    void getUserId() {
        int answer=user.getUserId();
        assertEquals(1,answer);
    }

    @Test
    void setUserId() {
        user.setUserId(2);
        assertEquals(2,user.getUserId());
    }

    @Test
    void getName() {
        String name =user.getName();
        assertEquals("Peter",name);
    }

    @Test
    void setName() {
        user.setName("Ibbe");
        assertEquals("Ibbe",user.getName());
    }
}