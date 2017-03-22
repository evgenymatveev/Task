package ru.ematveev;

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
    /**
     * Тест проверяет правильность сортировки файла.
     *
     * @throws Exception Exception.
     */
    @Test
    public void testSort() throws Exception {
        String sr = File.separator;
        File fR = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "textR.txt");
        File fW = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "textW.txt");

        SortBigFile sortBigFiler = new SortBigFile();
        sortBigFiler.sort(fR, fW);

        String line = "";
        File newFw = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "textW.txt");

        try {
            Scanner fileScanner = new Scanner(new FileReader(newFw));
            while (fileScanner.hasNext()) {
                line = line + fileScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(line, is("Оля" + "Евгений" + "Александр"));
    }
}

