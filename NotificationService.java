/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
// NotificationService.java
public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {
        System.out.println("NotificationService initialized.");
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}