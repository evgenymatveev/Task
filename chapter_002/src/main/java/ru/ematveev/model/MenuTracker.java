package ru.ematveev.model;

import ru.ematveev.start.BaseAction;
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
     * Array numbers for item menu.
     */
    private int[] ranges;

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
        ranges = new int[x];
    }

    /**
     * Method recording the task in the array.
     */
    public void fillAction() {
        this.actions[0] = this.new AddItem("AddItem", 0);
        this.actions[1] = this.new ShowItems("ShowItems", 1);
        this.actions[2] = this.new UpdateItem("UpdateItem", 2);
        this.actions[3] = this.new DeleteItem("DeleteItem", 3);
        this.actions[4] = new FindByNameItem("FindByNameItem", 4);
        this.actions[5] = new FindByIdItem("FindByIdItem", 5);
        this.actions[6] = new DeleteAllItem("DeleteAllItem", 6);
        this.actions[7] = new AddCommentForItem("AddCommentForItem", 7);
    }

    /**
     * Method for create the array.
     * @return array int[];
     */
    public int[] numberItems() {
        for (int i = 0; i < actions.length; i++) {
            this.ranges[i] = i;
        }
        return this.ranges;
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
    private class AddItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        AddItem(String name, int key) {
            super(name, key);
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
    }

    /**
     * Class ShowItems - implement the interface UserAction for show the items.
     */
    private class ShowItems extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        ShowItems(String name, int key) {
            super(name, key);
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
    }
    /**
     * Class DeleteItem - implement the interface UserAction for delete the item.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        DeleteItem(String name, int key) {
            super(name, key);
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
    }

    /**
     * Class findByNameItem - implement the interface UserAction for search the item named.
     */
    private class FindByNameItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        FindByNameItem(String name, int key) {
            super(name, key);
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
    }

    /**
     * Class findByIdItem - implement the interface UserAction for search the item id.
     */
    private class FindByIdItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        FindByIdItem(String name, int key) {
            super(name, key);
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
    }
    /**
     * Class UpdateItem - implement the interface UserAction for update the item.
     */
    private class UpdateItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        UpdateItem(String name, int key) {
            super(name, key);
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
    }

    /**
     * Class DeleteAllItem - implement the interface UserAction for delete all the item.
     */
    private class DeleteAllItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        DeleteAllItem(String name, int key) {
            super(name, key);
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
    }
    /**
     * Class AddCommentForItem - implement the interface UserAction for add comment in the item.
     */
    private class AddCommentForItem extends BaseAction {
        /**
         * Constructor.
         * @param name name.
         * @param key key.
         */
        AddCommentForItem(String name, int key) {
            super(name, key);
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
    }
}
