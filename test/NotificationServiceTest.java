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
public class NotificationServiceTest {
    
    public NotificationServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    /**
     * Test of getInstance method, of class NotificationService.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        NotificationService expResult = null;
        NotificationService result = NotificationService.getInstance();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendNotification method, of class NotificationService.
     */
    @Test
    public void testSendNotification() {
        System.out.println("sendNotification");
        String message = "";
        NotificationService instance = null;
        instance.sendNotification(message);
        fail("The test case is a prototype.");
    }
    
}
