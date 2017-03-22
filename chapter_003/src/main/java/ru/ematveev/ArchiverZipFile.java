package ru.ematveev;

//import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Matveev Evgeny.
 */
public class ArchiverZipFile {
    /**
     * The file which needs to be eventually archived.
     */
    private final File arhZip;
    /**
     * Directory from which to read files.
     */
    private final File inDir;
    /**
     * The list of extentions.
     */
    private final String[] ext;
    /**
     * The switch for the method checkFile() checking extensions.
     */
    private boolean flag = false;

    /**
     * The class that produces the archiving of files.
     * @param arhZip the file which needs to be eventually archived.
     * @param inDir the list of extentions.
     * @param ext the switch for the method checkFile() checking extensions.
     */
    public ArchiverZipFile(File arhZip, File inDir, String[] ext) {
        this.arhZip = arhZip;
        this.inDir = inDir;
        this.ext = ext;
    }

    /**
     * The method reviewer is to read the object directory or file.
     */
    public void checkDirectory() {

            if (inDir.isDirectory()) {
                File[] list = inDir.listFiles();
                    for (File item : list) {
                        if (item.isDirectory()) {
                            checkDirectory();
                        } else {
                            checkFile(item);
                                if (flag) {
                                    arh(item);
                                }
                        }
                    }
            }
    }

    /**
     * The method examines each file and compares the file extensions specified.
     * @param file check the file.
     * @return flag.
     */
    private boolean checkFile(File file) {
        for (String sExt : ext) {
            if (sExt.equals(getFileExtension(file))) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Returns the extension from the check file.
     * @param file check the file.
     * @return the extension or an empty string if there was no extension.
     */
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * Writes files into the archive.
     * @param in the file to write to the archive.
     */
    private void arh(File in) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(arhZip));
             FileInputStream fileInputStream = new FileInputStream(in);) {
                byte[] buffer = new byte[1024];
                zipOutputStream.setLevel(Deflater.DEFAULT_COMPRESSION);
                ZipEntry zipEntry = new ZipEntry(in.getName());
                zipOutputStream.putNextEntry(zipEntry);
                fileInputStream.read(buffer);
                zipOutputStream.write(buffer);
                zipOutputStream.closeEntry();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


