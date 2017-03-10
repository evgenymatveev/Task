import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class DeleteWordTest {
    /**
     * Test check work method dropAbuses().
     * @throws Exception Exception.
     */
    @Test
    public void testDropAbuses() throws Exception {
        String[] abuse = new String[]{"Petr", "Gleb"};
        String inp = "SlavaPetrGlebEvgen";
        byte[] inpByte = inp.getBytes();
        DeleteWord d = new DeleteWord();

        try (InputStream in = new ByteArrayInputStream(inpByte);
             OutputStream out = new ByteArrayOutputStream()) {

            d.dropAbuses(in, out, abuse);

            assertThat(out.toString(), is("SlavaEvgen"));
        }
    }

}