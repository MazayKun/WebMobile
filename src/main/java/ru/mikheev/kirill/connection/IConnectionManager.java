package ru.mikheev.kirill.connection;

import java.sql.Connection;

/**
 * Интерфейс отвечает за классы, возвращающие одключение к базе данных
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IConnectionManager {
    Connection getConnection();
}
