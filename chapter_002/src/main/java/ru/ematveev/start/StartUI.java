package ru.ematveev.start;

import ru.ematveev.model.Item;
import ru.ematveev.model.Task;

/**
 * Сlass StartUI run the project.
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 25.12.2016.
 */
public class StartUI {
    /**
     * Metod main run the project.
     * @param args args.
     */
    public static void main(String[] args) {
        final int count1 = 10;
        final int count2 = 20;
        final int count3 = 30;
        Tracker tracker = new Tracker();
        Item task = new Task("first task", "first desc", count1);
        Item item = new Item("item", "item desc", count2);
        Item task2 = new Task("second task", "second desc", count3);

        tracker.add(task);
        tracker.add(task2);
        tracker.add(item);

        for (Item i : tracker.findAll()) {
            System.out.println(i.getName() + " " + i.getId());

        }
        tracker.delete(task2);
        tracker.delete(task);
        for (Item i : tracker.findAll()) {
            System.out.println(i.getName() + " " + i.getId());

        }
    }
}
