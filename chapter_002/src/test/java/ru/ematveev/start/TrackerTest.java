package ru.ematveev.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;
import ru.ematveev.model.Item;
import ru.ematveev.model.Task;


/**
 * Class.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 26.12.16.
 */
public class TrackerTest {
    /**
     * The metod testAdd() checks for adding items to the array.
     * @throws Exception exception.
     */
    @Test
    public void testAdd() throws Exception {
        final long count = 5;

        Tracker tracker = new Tracker();

        Item item = new Item("task", "enter", count);

        assertSame(item, tracker.add(item));
    }

    /**
     * The metod testUpdate() checks for editing items.
     * @throws Exception exception.
     */
    @Test
    public void testUpdate() throws Exception {
        final long count = 5;

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Task("task", "descrip", count));

        tracker.update(item.getId(), new Task("task", "description", count));

        Item itemUpdate = tracker.findByName("task");

        String actualValue = itemUpdate.getDescription();

        assertThat(actualValue, is("description"));

    }

    /**
     * The metod testDelete() checks for deleting items.
     * @throws Exception exception.
     */
    @Test
    public void testDelete() throws Exception {
        final long count = 5;

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("task", "enter", count));

        String itemID = item.getId();

        tracker.delete(item);

        assertNull(tracker.findById(itemID));
    }

    /**
     * The metod testFindAll() checks the output is not null items.
     * @throws Exception exception.
     */
    @Test
    public void testFindAll() throws Exception {
        final long count = 5;

        Tracker tracker = new Tracker();

        Item item = new Item("task", "enter", count);
        Item item1 = new Item("task1", "enter1", count);
        Item item2 = new Item("task2", "enter2", count);
        Item item3 = new Item("task2", "enter2", count);

        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item[] actualValue = tracker.findAll();

        assertThat(actualValue, is(new Item[]{item, item1, item2, item3}));

    }

    /**
     * The metod testFindByName() looking for elements by name.
     * @throws Exception exception.
     */
    @Test
    public void testFindByName() throws Exception {
        final long count = 5;

        Tracker tracker = new Tracker();

        Item item = new Item("task", "enter", count);

        tracker.add(item);

        Item actualValue = tracker.findByName("task");

        assertThat(actualValue, is(item));
    }

    /**
     * The metod testFindById() looking for elements by ID.
     * @throws Exception exception.
     */
    @Test
    public void findById() throws Exception {
        final long count = 5;

        Tracker tracker = new Tracker();

        Item item = new Item("task", "enter", count);

        tracker.add(item);

        String itemID = item.getId();

        assertThat(tracker.findById(itemID), is(item));
    }

    /**
     * The method validates generation of a random number and convert it to a string.
     * @throws Exception exception.
     */
    @Test
    public void testGenerateId() throws Exception {
        final int x = 10000;

        Tracker tracker = new Tracker();

        String actualValue1 = "";
        String actualValue2 = "";

        for (int i = 0; i < x; i++) {
            actualValue1 = tracker.generateId();
            actualValue2 = tracker.generateId();

            assertNotEquals(actualValue1, actualValue2);
        }
    }

}