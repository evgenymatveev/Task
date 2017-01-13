package ru.ematveev;

import org.junit.Before;
import org.junit.Test;
import ru.ematveev.model.Item;
import ru.ematveev.model.MenuTracker;
import ru.ematveev.model.Task;
import ru.ematveev.start.Input;
import ru.ematveev.start.StartUI;
import ru.ematveev.start.StubInput;
import ru.ematveev.start.Tracker;
import static org.hamcrest.core.Is.is;
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

        MenuTracker.IPrinter printer = new MenuTracker.IPrinter() {
            @Override
            public void println(String text) {
                System.out.println(text);
            }
        };

        new StartUI(input, tracker, printer).init();

        assertThat(tracker.findAll()[0].getName(), is("task"));
        assertThat(tracker.findAll()[0].getDescription(), is("desc"));
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

        final MenuTracker.IPrinter printer = mock(MenuTracker.IPrinter.class);

        new StartUI(input, tracker, printer).init();

        String id = tracker.findAll()[0].getId();

        verify(printer).println(id + "." + " " + "task" + "." + " " + "desc");
    }





}
