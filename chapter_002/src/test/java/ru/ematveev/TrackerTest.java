package ru.ematveev;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import ru.ematveev.model.Item;
import ru.ematveev.start.Tracker;

/**
 * Class TrackerTest for testing of the metods of the class Tracker.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 26.12.16.
 */
public class TrackerTest {
    /**
     * Count.
     */
    private final long count = 5;
    /**
     * Tracker for create the object.
     */
    private Tracker tracker;
    /**
     * Item for create the item.
     */
    private Item item;
    /**
     * Item for create the item1.
     */
    private Item item1;
    /**
     * Item for create the item2.
     */
    private Item item2;

    /**
     * Metod testCreateObjectAndItemsForTests for set persistent variables.
     */
    @Before
    public void testCreateObjectAndItemsForTests() {

        tracker = new Tracker();

        item = new Item("task", "descr", count);

        item1 = new Item("task1", "descr1", count);

        item2 = new Item("task2", "descr2", count);
    }
    /**
     * The metod testAdd() checks for adding items to the array.
     * @throws Exception exception.
     */
    @Test
    public void testAdd() throws Exception {

        assertSame(item, tracker.add(item));
    }

    /**
     * The metod testUpdate() checks for editing items.
     * @throws Exception exception.
     */
    @Test
    public void testUpdate() throws Exception {
        tracker.add(item);

        Item task = new Item("task", "description", count);

        task.setId(item.getId());

        tracker.update(item.getId(), task);

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
        Item task = tracker.add(item);

        String itemID = task.getId();

        tracker.delete(task);

        assertNull(tracker.findById(itemID));
    }

    /**
     * The metod testFindAll() checks the output is not null items.
     * @throws Exception exception.
     */
    @Test
    public void testFindAll() throws Exception {
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);

        Item[] actualValue = tracker.findAll();

        assertThat(actualValue, is(new Item[]{item, item1, item2}));
    }

    /**
     * The metod testFindByName() looking for elements by name.
     * @throws Exception exception.
     */
    @Test
    public void testFindByName() throws Exception {

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

        String actualValue1 = "";
        String actualValue2 = "";

        for (int i = 0; i < x; i++) {
            actualValue1 = tracker.generateId();
            actualValue2 = tracker.generateId();

            assertNotEquals(actualValue1, actualValue2);
        }
    }

    /**
     * The metod testDeleteAll() checks for deleting all items.
     * @throws Exception exception.
     */
    @Test
    public void testDeleteAll() throws Exception {
        Item task = tracker.add(item);
        Item task1 = tracker.add(item1);
        Item task2 = tracker.add(item2);

        tracker.deleteAll();

        assertThat(0, is(tracker.findAll().length));
    }

}