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
     * Create IPrinter for testing void method.
     */
    private IPrinter printer;
    /**
     * The number of menu items.
     */
    private final int x = 8;
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
     * @param printer printer.
     */
    public MenuTracker(Input input, Tracker tracker, IPrinter printer) {
        this.input = input;
        this.tracker = tracker;
        this.printer = printer;
    }

    /**
     * Method recording the task in the array.
     */
    public void fillAction() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowItems();
        this.actions[2] = this.new UpdateItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new FindByNameItem();
        this.actions[5] = new FindByIdItem();
        this.actions[6] = new DeleteAllItem();
        this.actions[7] = new AddCommentForItem();
    }
    /**
     * Method the key number calling method execute().
     * @param key key.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker, this.printer);
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
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
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
    private class ShowItems implements UserAction {
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
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
            for (Item item : tracker.findAll()) {
                printer.println(
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
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
            String id = input.ask("Please, enter the task's id: ");
            Item task = tracker.findById(id);
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
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
            String name = input.ask("Please, enter the task's name: ");
            Item item = tracker.findByName(name);
            printer.println(
                    String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription())
            );
            item.getComments().arrayOutComment(printer);
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
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            printer.println(
                    String.format("%s. %s. %s", item.getId(), item.getName(), item.getDescription())
            );
            item.getComments().arrayOutComment(printer);
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
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
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

    /**
     * Class DeleteAllItem - implement the interface UserAction for delete all the item.
     */
    private class DeleteAllItem implements UserAction {
        /**
         * Number key for memu.
         */
        private final int countKey = 6;
        /**
         * The method returns the number key.
         * @return number 2.
         */
        public int key() {
            return countKey;
        }

        /**
         * The method receives a confirmation from user and removes all items.
         * @param input input.
         * @param tracker tracker.
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
            String confirm = input.ask("Are you sure want do delete all items?: ");
            if (confirm.equals("y")) {
                tracker.deleteAll();
            }
        }

        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete all the item.");
        }
    }
    /**
     * Class AddCommentForItem - implement the interface UserAction for add comment in the item.
     */
    private class AddCommentForItem implements UserAction {
        /**
         * Number key for memu.
         */
        private final int countKey = 7;
        /**
         * The method returns the number key.
         * @return number 2.
         */
        public int key() {
            return countKey;
        }

        /**
         * The method receives a confirmation from user and removes all items.
         * @param input input.
         * @param tracker tracker.
         * @param printer printer.
         */
        public void execute(Input input, Tracker tracker, IPrinter printer) {
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            String comm = (input.ask("Please, enter comment for your Item: "));
            item.getComments().addComments(comm);
        }

        /**
         * Method for output on the screen menu items.
         * @return String.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add comment for the item.");
        }
    }
}
