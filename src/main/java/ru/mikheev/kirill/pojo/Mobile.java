package ru.mikheev.kirill.pojo;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

public class Mobile {

    private Integer id;
    private String model;
    private Integer price;


    public Mobile() {}

    public Mobile(Integer id, String model, Integer price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * @return
     */
    public Integer getPrice() {
        return price;
    }
}
