package ru.mikheev.kirill.pojo;

/**
 * Простой поджик хранимых в таблице mobile объектов
 * @author Kirill Mikheev
 * @version 1.0
 */

public class Mobile {

    /**
     * Значения всех столбцов из таблички
     */
    private Integer id;
    private String model;
    private Integer price;

    /**
     * Конструктор принимает на вход значения всех полей объекта
     * @param id
     * @param model
     * @param price
     */
    public Mobile(Integer id, String model, Integer price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }
}
