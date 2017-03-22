package ru.ematveev;

import org.junit.Test;

import java.io.File;

/**
 * @author Matveev Evgeny.
 */
public class ArchiverZipFileTest {
    @Test
    public void testArh() throws Exception {

        String sr = File.separator;
        String s = ".txt";
        File fileOutZip = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "output.zip");
        File fileIn = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J");

        ArchiverZipFile archiverZipFile = new ArchiverZipFile();
        archiverZipFile.arh(fileOutZip, fileIn, s);

    }

}