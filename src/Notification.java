/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Notification {
    private String message;
    private String recipientId;

    public Notification(String message, String recipientId) {
        this.message = message;
        this.recipientId = recipientId;
    }

    public void send() {
        System.out.println("Notification sent to " + recipientId + ": " + message);
    }

    public void scheduleReminder() {
        System.out.println("Reminder scheduled for " + recipientId);
    }
}
