package ru.ematveev.start;

import ru.ematveev.model.MenuTracker;

/**
 * Сlass StartUI run the project.
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class StartUI {
    /**
     * Variable input interface implementations.
     */
    private Input input;

    /**
     * Constructor.
     * @param input input.
     */
    public StartUI(Input input) {
        this.input = input;
    }
    /**
     * The initialization method work.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit(y):")));
    }
    /**
     * Metod main run the project.
     * @param args args.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}
