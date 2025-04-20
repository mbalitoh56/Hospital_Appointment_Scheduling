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
public class AppointmentProcessorTest {
    
    public AppointmentProcessorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    /**
     * Test of processAppointment method, of class AppointmentProcessor.
     */
    @Test
    public void testProcessAppointment() {
        System.out.println("processAppointment");
        AppointmentProcessor instance = new AppointmentProcessorImpl();
        instance.processAppointment();
        fail("The test case is a prototype.");
    }

    public class AppointmentProcessorImpl implements AppointmentProcessor {

        public void processAppointment() {
        }
    }
    
}
