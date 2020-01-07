package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.pojo.Mobile;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IMobileDAO {
    void createTable();

    void addMobile(Mobile mobile);

    Mobile getMobileById();
}
