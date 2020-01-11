package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.connection.IConnectionManager;
import ru.mikheev.kirill.pojo.Mobile;

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
public class MobileDAO implements IMobileDAO{

    public static final String INSERT_INTO_MOBILE = "INSERT INTO mobile values (DEFAULT, ?, ?)";
    public static final String SELECT_FROM_MOBILE = "SELECT * FROM mobile WHERE id = ?";
    public static final String SELECT_ALL_FROM_MOBILE = "SELECT * FROM mobile";
    public static final String UPDATE_MOBILE = "UPDATE mobile SET model=?, price=? WHERE id=?";
    public static final String DELETE_FROM_MOBILE = "DELETE FROM mobile WHERE id=?";
    public static final String DROP_TABLE_MOBILE = "DROP TABLE IF EXISTS mobile;" ;
    public static final String CREATE_TABLE_MOBILE
            = "DROP TABLE IF EXISTS mobile;\n"
            + "create table mobile\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint mobile_pkey\n"
            + "            primary key,\n"
            + "    model varchar(100) not null,\n"
            + "    price integer not null\n"
            + ");\n";

    private IConnectionManager connectionManager;

    @Inject
    public MobileDAO(IConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void createTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_MOBILE)) {
             preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addMobile(Mobile mobile) {
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_MOBILE)) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setInt(2, mobile.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mobile getMobileById(int id) {
        Mobile mobile = null;
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_MOBILE)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            mobile = new Mobile(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            resultSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return mobile;
        }
    }

    @Override
    public void deleteMobileById(int id) {
        try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_MOBILE)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMobileById(int id, Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOBILE)){
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, mobile.getId());
            preparedStatement.setString(3, mobile.getModel());
            preparedStatement.setInt(4, mobile.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Mobile> getAllMobiles() {
        List<Mobile> mobileList = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_MOBILE)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                mobileList.add(
                        new Mobile(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3))
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return mobileList;
        }
    }

    @Override
    public void dropTable() {
        try (Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_MOBILE)){
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
