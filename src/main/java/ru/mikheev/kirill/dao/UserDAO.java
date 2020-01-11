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
 * @author Kirill Mikheev
 * @version 1.0
 */

@EJB
public class UserDAO implements IUserDAO {

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

    private IConnectionManager connectionManager;

    @Inject
    public UserDAO(IConnectionManager connectionManager){
        this.connectionManager = connectionManager;
    }

    @Override
    public void createTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_USERS)){
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
