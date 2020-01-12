package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.connection.IConnectionManager;
import ru.mikheev.kirill.pojo.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Класс реализует интейрффейс IUserDAO и отвечает за взаимодейтсиве с табличкой users из бд
 * @author Kirill Mikheev
 * @version 1.0
 */

@EJB
public class UserDAO implements IUserDAO {

    /**
     * Запросы к базе данных, которые используются в методах
     */
    public static final String INSERT_INTO_USERS = "INSERT INTO users values (DEFAULT, ?, ?, ?, ?)";
    public static final String SELECT_FROM_USERS = "SELECT * FROM users WHERE name = ?";
    public static final String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    public static final String DROP_TABLE_USERS = "DROP TABLE IF EXISTS users;" ;
    public static final String CREATE_TABLE_USERS
            = "DROP TABLE IF EXISTS users;\n"
            + "create table users\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint user_pkey\n"
            + "            primary key,\n"
            + "    name varchar(100) not null,\n"
            + "    password varchar(100) not null,\n"
            + "    email varchar(100) not null,\n"
            + "    phone_number varchar(100) not null\n"
            + ");\n";

    /**
     * ConnectionManager, который выдает подключение к бд, когда нужно
     */
    private IConnectionManager connectionManager;

    /**
     * Конструктор принимает на вход connectionManager
     * @param connectionManager
     */
    @Inject
    public UserDAO(IConnectionManager connectionManager){
        this.connectionManager = connectionManager;
    }

    /**
     * Создает ту самую табличку
     */
    @Override
    public void createTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_USERS)){
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавляет новый объект в табличку
     * @param user объект, который нужно добавить
     */
    @Override
    public void addUser(User user) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USERS)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение пользователя по его имени
     * @param name строка, содержащая имя пользователя, который нам нужен
     * @return
     */
    @Override
    public User getUserByName(String name) {
        User user = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USERS)){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return user;
        }
    }

    /**
     * Возвращает список всех пользователей, которые зарегистрированы
     * @return Объект типа Collection, который содержит все хранимые в таблице объекты
     */
    @Override
    public Collection<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_USERS)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                usersList.add(
                        new User(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5)
                        )
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return usersList;
        }
    }

    /**
     * Удаляет эту таблицу
     */
    @Override
    public void dropTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_USERS)){
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
