import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class CheckedByteEvenTest {
    /**
     * The test checkes that if in the input comes even number method isNumber() return true.
     * @throws IOException IOException.
     */
    @Test
    public void testIsNumberWhenNumberIsEvenNumber() throws IOException {
        String a = "2";
        CheckedByteEven b = new CheckedByteEven();

        try (InputStream byteArrayInputStream = new ByteArrayInputStream(a.getBytes())) {

                assertThat(b.isNumber(byteArrayInputStream), is(true));
            }
        }
    /**
     * The test checkes that if in the input comes odd number method isNumber() return false.
     * @throws IOException IOException.
     */
    @Test
    public void testIsNumberWhenNumberIsOddNumber() throws IOException {
        String a = "3";
        CheckedByteEven b = new CheckedByteEven();

        try (InputStream byteArrayInputStream = new ByteArrayInputStream(a.getBytes())) {

            assertThat(b.isNumber(byteArrayInputStream), is(false));
        }
    }
    }



