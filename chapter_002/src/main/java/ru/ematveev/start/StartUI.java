package ru.ematveev.start;

import ru.ematveev.model.IPrinter;
import ru.ematveev.model.MenuTracker;

import java.util.List;

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
    private IPrinter printer;

    /**
     * Constructor.
     * @param input input.
     * @param tracker tracker.
     * @param printer printer.
     */
    public StartUI(Input input, Tracker tracker, IPrinter printer) {
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
            List<Integer> resultmenu = menu.numberItems();
            menu.select(input.ask("Select:", resultmenu));
        } while (!"y".equals(this.input.ask("Exit(y):")));
    }
    /**
     * Metod main run the project.
     * @param args args.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        IPrinter printer = new IPrinter() {
            @Override
            public void println(String text) {
                System.out.println(text);
            }
        };
        new StartUI(input, tracker, printer).init();
    }
}
