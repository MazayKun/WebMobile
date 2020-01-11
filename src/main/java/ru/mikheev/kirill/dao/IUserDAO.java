package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.pojo.User;

import java.util.Collection;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IUserDAO {
    void createTable();

    void addUser(User user);

    User getUserByName(String name);

    Collection<User> getAllUsers();

    void dropTable();
}
