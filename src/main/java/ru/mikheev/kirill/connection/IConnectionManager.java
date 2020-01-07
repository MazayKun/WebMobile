package ru.mikheev.kirill.connection;

import java.sql.Connection;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IConnectionManager {
    Connection getConnection();
}
