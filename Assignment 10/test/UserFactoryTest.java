/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */
public class UserFactoryTest {
    
    public UserFactoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    /**
     * Test of createUser method, of class UserFactory.
     */
    @Test
    public void testCreateUser() {
    User user = (User) UserFactory.createUser("Patient", "John");
    assertTrue(user instanceof Patient);
    assertEquals("John", user.getName());
    }
    
}
