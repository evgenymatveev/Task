package ru.ematveev.start;

import ru.ematveev.model.IPrinter;


/**
 * Interface for create the key, format string and prompting the user information of the application and adds it to the.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 06.01.17.
 */
public interface UserAction {
    /**
     * Base the method returns the number key.
     * @return 0.
     */
    int key();

    /**
     * Base the method prompting the user information of the application and adds it to the array.
     * @param input input.
     * @param tracker tracker.
     * @param printer printer.
     */
    void execute(Input input, Tracker tracker, IPrinter printer);

    /**
     * Base method for output on the screen menu items.
     * @return String.
     */
    String info();
}
