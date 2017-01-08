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
    private final int x = 6;
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
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = this.new UpdateItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new FindByNameItem();
        this.actions[5] = new FindByIdItem();
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
         * @return number 0.
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

    /**
     * Class ShowItems - implement the interface UserAction for show the items.
     */
    private static class ShowItems implements UserAction {
        /**
         * The method returns the number key.
         * @return number 1.
         */
        public int key() {
            return 1;
        }

        /**
         * The method displays on screen all the items.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription())
                );
            }
        }

        /**
         * Method for output on the screen all the items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Class DeleteItem - implement the interface UserAction for delete the item.
     */
    private class DeleteItem implements UserAction {
        /**
         * Number key for memu.
         */
        private final int countKey = 3;
        /**
         * The method returns the number key.
         * @return number 2.
         */
        public int key() {
            return countKey;
        }

        /**
         * The method prompting the user information of the application and delete item.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            Item task = tracker.findById(id);
            task.setId(id);
            tracker.delete(task);
        }

        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }
    }

    /**
     * Class findByNameItem - implement the interface UserAction for search the item named.
     */
    private class FindByNameItem implements UserAction {
        /**
         * Number key for memu.
         */
        private final int countKey = 4;
        /**
         * The method returns the number key.
         * @return number 4.
         */
        public int key() {
            return countKey;
        }

        /**
         * The method search for an item named.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            Item item = tracker.findByName(name);
            System.out.println(
                    String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription())
            );
        }

        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Search the item named.");
        }
    }

    /**
     * Class findByIdItem - implement the interface UserAction for search the item id.
     */
    private class FindByIdItem implements UserAction {
        /**
         * Number key for memu.
         */
        private final int countKey = 5;
        /**
         * The method returns the number key.
         * @return number 5.
         */
        public int key() {
            return countKey;
        }

        /**
         * The method search for an item named.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            System.out.println(
                    String.format("%s, %s, %s", item.getId(), item.getName(), item.getDescription())
            );
        }

        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Search the item Id.");
        }
    }
    /**
     * Class UpdateItem - implement the interface UserAction for update the item.
     */
    private class UpdateItem implements UserAction {

        /**
         * The method returns the number key.
         * @return number 2.
         */
        public int key() {
            return 2;
        }
        /**
         * The method prompting the user information of the application and update the item.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's desc: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.update(task.getId(), task);
        }
        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit the item.");
        }
    }



}
