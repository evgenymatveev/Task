package ru.ematveev;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;

/**
 * @author Matveev Evgeny.
 */
public class ArchiverZipFileTest {
    /**
     * This test verifies the creation of the archive.
     * @throws Exception Exception.
     */
    @Test
    public void testCheckDirectory() throws Exception {

        String sr = File.separator;
        String[] ext = new String[]{"txt", "xml"};
        File fileOutZip = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "output.zip");
        File fileIn = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J");

        ArchiverZipFile archiverZipFile = new ArchiverZipFile(fileOutZip, fileIn, ext);
        archiverZipFile.checkDirectory();

        File file = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "output.zip");
        assertNotNull(file);
    }

}