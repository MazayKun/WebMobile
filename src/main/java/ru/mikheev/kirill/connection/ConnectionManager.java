package ru.mikheev.kirill.connection;

import javax.ejb.EJB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

@EJB
public class ConnectionManager implements IConnectionManager {

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://host.docker.internal:5433/mobile",
                    "postgres",
                    "admin");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
