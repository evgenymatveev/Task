package ru.ematveev.model;

import java.util.Objects;

/**
 * Сlass Item for create the item with three enter option .
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class Item {
    /**
     * Name.
     */
    private String name;
    /**
     * Description.
     */
    private String description;
    /**
     * Time create the item.
     */
    private long create;
    /**
     * Personal number.
     */
    private String id;
    /**
     * Comment.
     */
    private Comment comments;

    /**
     * default constructor.
     */
    public Item() {

    }
    /**
     * constructor for the three parameters.
     * @param name name.
     * @param description descriptiion.
     * @param create create.
     */

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.comments = new Comment();
    }

    /**
     * constructor for the two parameters.
     * @param name name.
     * @param description description.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.comments = new Comment();
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

    /**
     * Method for return the comment.
     * @return comments.
     */
    public Comment getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return create == item.create &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(id, item.id) &&
                Objects.equals(comments, item.comments);
    }
}


