package ru.mikheev.kirill.dao;

import ru.mikheev.kirill.pojo.Mobile;

import java.util.Collection;

/**
 * Интерфейс, описывающий даошку, которая отвечает за взаимодейтствие с табличкой mobile из бд
 * @author Kirill Mikheev
 * @version 1.0
 */

public interface IMobileDAO {

    /**
     * Создает ту самую табличку
     */
    void createTable();

    /**
     * Удаляет эту таблицу
     */
    void dropTable();

    /**
     * Добавляет новый элемент в табличку
     * @param mobile объект, который нужно добавить
     */
    void addMobile(Mobile mobile);

    /**
     * Получение мобильника с заданным айдишником из таблички
     * @param id нужного мобильника
     * @return объект типа Mobile
     */
    Mobile getMobileById(int id);

    /**
     * удаление мобильника с заданным айдишником
     * @param id мобильника, который нужно удалить
     */
    void deleteMobileById(int id);

    /**
     * Изменение мобильника с заданным айдиником
     * @param id мобильника, который нужно изменить
     * @param mobile новое значение
     */
    void updateMobileById(int id, Mobile mobile);

    /**
     * Возвращает список всех мобильников из таблички
     * @return объект тиа Collection, который содержит все объекты из таблицы
     */
    Collection<Mobile> getAllMobiles();
}
