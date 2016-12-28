package ru.ematveev.model;

/**
 * Сlass Task for create the item with two enter option .
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class Task extends Item {
    /**
     * Constructor for Task.
     * @param name name.
     * @param desc description.
     * @param create create.
     */
    public Task(String name, String desc, long create) {
        super(name, desc, create);
    }

    /**
     * Metod for test.
     * @return String.
     */
    public String calculatePrice() {
        return "100%";
    }
}
