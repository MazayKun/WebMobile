package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.connection.IConnectionManager;
import ru.mikheev.kirill.pojo.Mobile;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

@EJB
public class MobileDAO implements IMobileDAO{

    public static final String CREATE_TABLE_MOBILE
            = "DROP TABLE IF EXISTS mobile;\n"
            + "create table mobile\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint mobile_pkey\n"
            + "            primary key,\n"
            + "    model varchar(100) not null,\n"
            + "    price integer not null,\n"
            + "    manufacturer varchar(100) not null\n"
            + ");\n"
            + "\n"
            + "alter table mobile owner to postgres;";

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
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void addMobile(Mobile mobile) {

    }

    @Override
    public Mobile getMobileById() {
        return null;
    }
}
