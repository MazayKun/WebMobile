package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.pojo.Mobile;

import java.util.Collection;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IMobileDAO {
    void createTable();

    void addMobile(Mobile mobile);

    Mobile getMobileById(int id);

    void deleteMobileById(int id);

    void updateMobileById(int id, Mobile mobile);

    Collection<Mobile> getAllMobiles();

    void dropTable();
}
