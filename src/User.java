/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
    public abstract class User {
    protected String userId;
    protected String name;
    protected String username;
    protected String password;

    public User(String userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public abstract void login();
    public abstract void logout();

    // Getters and Setters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    }