package ru.ematveev;

import org.junit.Before;
import org.junit.Test;
import ru.ematveev.model.IPrinter;
import ru.ematveev.model.Item;
import ru.ematveev.model.MenuTracker;
import ru.ematveev.model.Task;
import ru.ematveev.start.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Class.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 03.01.17.
 */
public class StartUITest {
    /**
     * Used the Tracker.
     */
    private Tracker tracker;
    /**
     * Method setUp() for baseline values for testing.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        tracker = new Tracker();
    }

    /**
     * Test for added the item.
     * @throws Exception Exception.
     */
    @Test
     public void testWhenUserAddNewItem() throws Exception {
        Input input = new StubInput(new String[] {"0", "task", "desc", "y"});
        IPrinter printer = text -> System.out.println(text);

        new StartUI(input, tracker, printer).init();

        String expectedValue = tracker.findByName("task").getId();


        assertThat(tracker.findAll()[0].getId(), is(expectedValue));
    }

    /**
     * Test for updated the item.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserShowItem() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        Input input = new StubInput(new String[] {"1", "y"});

        final IPrinter printer = mock(IPrinter.class);

        new StartUI(input, tracker, printer).init();

        String id = tracker.findAll()[0].getId();

        verify(printer).println(id + "." + " " + "task" + "." + " " + "desc");
    }

    /**
     * Test for update the item.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserUpdateItem() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        String id = tracker.findAll()[0].getId();

        Input input = new StubInput(new String[] {"2", id, "task1", "desc1", "y"});

        IPrinter printer = text -> System.out.println(text);

//        IPrinter printer = new IPrinter() {
//            @Override
//            public void println(String text) {
//                System.out.println(text);
//            }
//        };

        new StartUI(input, tracker, printer).init();

        Item task2 = new Task("task1", "desc1");

        task2.setId(id);

        assertEquals(tracker.findById(id), task2);
    }

    /**
     * Test for delete the item.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserDeleteItem() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        String id = tracker.findAll()[0].getId();

        Input input = new StubInput(new String[] {"3", id, "y"});

        IPrinter printer = text -> System.out.println(text);

        new StartUI(input, tracker, printer).init();

        assertNull(tracker.findById(id));

    }

    /**
     * Test for search by name the item.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserSearchByNameItem() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        Input input = new StubInput(new String[] {"4", "task", "y"});

        final IPrinter printer = mock(IPrinter.class);

        new StartUI(input, tracker, printer).init();

        String id = tracker.findAll()[0].getId();

        verify(printer).println(id + "." + " " + "task" + "." + " " + "desc");

    }

    /**
     * Test for search by id the item.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserSearchByIdItem() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        String id = tracker.findAll()[0].getId();

        Input input = new StubInput(new String[] {"5", id, "y"});

        final IPrinter printer = mock(IPrinter.class);

        new StartUI(input, tracker, printer).init();


        verify(printer).println(id + "." + " " + "task" + "." + " " + "desc");

    }
    /**
     * Test for delete the all item, but user answer no.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserDeleteAllItemButAnswerNon() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        String id = tracker.findAll()[0].getId();

        Input input = new StubInput(new String[] {"6", "n", "y"});

        IPrinter printer = text -> System.out.println(text);

        new StartUI(input, tracker, printer).init();

        assertThat(tracker.findAll()[0].getName(), is("task"));

    }
    /**
     * Test for delete the all item, but user answer yes.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserDeleteAllItemButAnswerYes() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        String id = tracker.findAll()[0].getId();

        Input input = new StubInput(new String[] {"6", "y", "y"});

        IPrinter printer = text -> System.out.println(text);

        new StartUI(input, tracker, printer).init();

        assertNull(tracker.findById(id));
    }
    /**
     * Test for add comments to Item.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenUserAddComment() throws Exception {
        Item task = new Task("task", "desc");

        tracker.add(task);

        String id = tracker.findAll()[0].getId();

        Input input = new StubInput(new String[] {"7", id, "comment1", "y"});

        final IPrinter printer = mock(IPrinter.class);

        new StartUI(input, tracker, printer).init();

        task.getComments().arrayOutComment(printer);

        verify(printer).println("comment1");
    }

}
