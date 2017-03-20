import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class SortBigFileTest {
    @Test
    public void testSort() throws Exception {
        File fR = new File("textR.txt");
        File fW = new File("textW.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(fR, false));

            writer.write("Евгений" + "\n"
                    + "Александр" + "\n"
                    + "Оля" + "\n");
            writer.flush();
            writer.close();
            SortBigFile sortBigFile = new SortBigFile();
            sortBigFile.sort(fR, fW);

        String line;
        String result = "";

        String s = "Оля" + "\n" + "Евгений" + "\n" + "Александр" + "\n";

        File newFw = new File("textW.txt");

        try (RandomAccessFile raf = new RandomAccessFile(newFw, "r")){
            while ((line = raf.readLine()) != null) {
                result = line +"\n";
            }

        }

            assertThat(result, is(s));

        }
    }

