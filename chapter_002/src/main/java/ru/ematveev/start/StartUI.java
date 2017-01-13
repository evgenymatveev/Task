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
     * Used the tracker.
     */
    private Tracker tracker;
    /**
     * Used the IPrinter.
     */
    private MenuTracker.IPrinter printer;


    /**
     * Constructor.
     * @param input input.
     * @param tracker tracker.
     * @param printer printer.
     */
    public StartUI(Input input, Tracker tracker, MenuTracker.IPrinter printer) {
        this.input = input;
        this.tracker = tracker;
        this.printer = printer;

    }
    /**
     * The initialization method work.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker, this.printer);
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
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        MenuTracker.IPrinter printer = new MenuTracker.IPrinter() {
            @Override
            public void println(String text) {
                System.out.println(text);
            }
        };
        new StartUI(input, tracker, printer).init();
    }
}
