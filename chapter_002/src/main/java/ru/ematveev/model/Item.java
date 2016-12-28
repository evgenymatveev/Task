package ru.ematveev.model;

/**
 * Сlass Item for create the item with three enter option .
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class Item {
    /**
     * name.
     */
    private String name;
    /**
     * description.
     */
    private String description;
    /**
     * time create the item.
     */
    private long create;
    /**
     * personal number.
     */
    private String id;

    /**
     * default constructor.
     */
    public Item() {

    }
    /**
     * constructor.
     * @param name name.
     * @param description descriptiion.
     * @param create create.
     */

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * method to retrieve the name.
     * @return name.
     */

    public String getName() {
        return this.name;
    }

    /**
     * method to retrieve the description.
     * @return description.
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * method to retrieve the create.
     * @return create.
     */

    public long getCreate() {
        return this.create;
    }

    /**
     * method to retrieve the ID.
     * @return id.
     */

    public String getId() {
        return this.id;
    }

    /**
     * Metod to write id.
     * @param id id.
     */

    public void setId(String id) {
        this.id = id;
    }
}


