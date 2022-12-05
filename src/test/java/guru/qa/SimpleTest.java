package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//disabled - can be all class or all methods
//all tests should be grouped into classes according to their business features. (e.g. LoginTest, RegistrationTest, ProfileTest, etc.)
//test naming should be meaningful, so that it is clear what is being tested

public class SimpleTest {
    @Disabled ("Task id: 123") //put here task id
    @DisplayName("check if 2 equals 2")
    @Test
    void firstTest (){
        Assertions.assertEquals(2, 2, "true");
    }

    @DisplayName("Checking if 2 is not equal to 3")
    @Test
    void secondTest (){
        Assertions.assertNotEquals(2, 3, "true");
    }







}
