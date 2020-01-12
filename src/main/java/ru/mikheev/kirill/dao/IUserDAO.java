package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.pojo.User;

import java.util.Collection;

/**
 * Интерфейс, описывающий даошку, которая отвечает за взаимодейтствие с табличкой users из бд
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IUserDAO {

    /**
     * Создает ту самую табличку
     */
    void createTable();

    /**
     * Удаляет эту таблицу
     */
    void dropTable();

    /**
     * Добавляет новый объект в табличку
     * @param user объект, который нужно добавить
     */
    void addUser(User user);

    /**
     * Получение пользователя по его имени
     * @param name строка, содержащая имя пользователя, который нам нужен
     * @return
     */
    User getUserByName(String name);

    /**
     * Возвращает список всех пользователей, которые зарегистрированы
     * @return Объект типа Collection, который содержит все хранимые в таблице объекты
     */
    Collection<User> getAllUsers();
}
