package ru.ematveev;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class SortBigFileTest {
    private File fR;
    private File fW;

    /**
     * Method will be before start testSort().
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        String sr = File.separator;
        fW = File.createTempFile("textW", ".txt");
        fR = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "textR.txt");
    }

    /**
     * Тест проверяет правильность сортировки файла.
     *
     * @throws Exception Exception.
     */
    @Test
    public void testSort() throws Exception {
        SortBigFile sortBigFiler = new SortBigFile();
        sortBigFiler.sort(fR, fW);

        String line = "";

        try {
            Scanner fileScanner = new Scanner(new FileReader(fW));
            while (fileScanner.hasNext()) {
                line = line + fileScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(line, is("Оля" + "Евгений" + "Александр"));
    }
}





