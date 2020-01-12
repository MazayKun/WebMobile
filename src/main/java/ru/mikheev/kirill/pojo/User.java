package ru.mikheev.kirill.pojo;

/**
 * Простой поджик хранимых в таблице users объектов
 * @author Kirill Mikheev
 * @version 1.0
 */

public class User {

    /**
     * Значения всех столбцов из таблички
     */
    private int id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;

    /**
     * Конструктор принимает на вход значения всех полей объекта
     * @param id
     * @param name
     * @param password
     * @param email
     * @param phoneNumber
     */
    public User(int id, String name, String password, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
