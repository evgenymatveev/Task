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
     */
    public Task(String name, String desc) {
        super(name, desc);
    }

    /**
     * Metod for test.
     * @return String.
     */
    public String calculatePrice() {
        return "100%";
    }
}
