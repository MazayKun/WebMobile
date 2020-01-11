package ru.mikheev.kirill.pojo;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;

    public User(int id, String name, String password, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
