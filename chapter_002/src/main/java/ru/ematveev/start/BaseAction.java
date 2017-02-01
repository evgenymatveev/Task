package ru.ematveev.start;

import ru.ematveev.model.IPrinter;

/**
 * Abstract class BaseAction implements UserAction.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 01.02.17.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Name the position the menu.
     */
    private String name;
    private int key;

    /**
     * Constructor.
     * @param name name.
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }
    /**
     * Base the method returns the number key.
     * @return 0.
     */
    public int key() {
        return key;
    }

    /**
     * Base the method prompting the user information of the application and adds it to the array.
     * @param input input.
     * @param tracker tracker.
     * @param printer printer.
     */
    public abstract void execute(Input input, Tracker tracker, IPrinter printer);

    /**
     * Base method for output on the screen menu items.
     * @return String.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
