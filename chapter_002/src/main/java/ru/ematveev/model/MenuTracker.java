package ru.ematveev.model;

import ru.ematveev.start.Input;
import ru.ematveev.start.Tracker;
import ru.ematveev.start.UserAction;

/**
 * Class for create menu.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 04.01.17.
 */
public class MenuTracker {
    /**
     * The number of menu items.
     */
    private final int x = 5;
    /**
     * Variable for input information from the user.
     */
    private Input input;
    /**
     * Variable for input tracker.
     */
    private Tracker tracker;
    /**
     * Create array actions for storage the task.
     */
    private UserAction[] actions = new UserAction[x];

    /**
     * Constructor MenuTracker.
     * @param input input.
     * @param tracker tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method recording the task in the array.
     */
    public void fillAction() {
        this.actions[0] = new AddItem();
    }

    /**
     * Method the key number calling method execute().
     * @param key key.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Method show the menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Inner class of the class MenuTracker implements the interface UserAction.
     */
    private class AddItem implements UserAction {
        /**
         * The method returns the number key.
         * @return 0.
         */
        public int key() {
            return 0;
        }

        /**
         * The method prompting the user information of the application and adds it to the array.
          * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            tracker.add(new Task(name, desc));
        }

        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }
}
