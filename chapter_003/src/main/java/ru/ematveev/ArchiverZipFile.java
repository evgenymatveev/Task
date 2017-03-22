package ru.ematveev;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Matveev Evgeny.
 */
public class ArchiverZipFile {
    private File[] list;
    public void arh(File z, File in, String s) {

        if(in.isDirectory()) {
            list = in.listFiles(new Filter(s));
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(z));)
            {

                        for (File item : list) {
                            FileInputStream fileInputStream = new FileInputStream(item);
                            ZipEntry zipEntry = new ZipEntry(item.getName());
                            zipOutputStream.putNextEntry(zipEntry);
                            byte[] buffer = new byte[fileInputStream.available()];
                            fileInputStream.read(buffer);
                            zipOutputStream.write(buffer);
                            zipOutputStream.closeEntry();
                        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





