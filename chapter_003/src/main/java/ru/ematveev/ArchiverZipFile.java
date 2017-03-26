package ru.ematveev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
     * The list of extentions.
     */
    private final String[] ext;

    /**
     * The class that produces the archiving of files.
     *
     * @param arhZip the file which needs to be eventually archived.
     * @param ext    the switch for the method checkFile() checking extensions.
     */
    public ArchiverZipFile(File arhZip, String[] ext) {
        this.arhZip = arhZip;
        this.ext = ext;
    }

    /**
     * The method reviewer is to read the object directory or file.
     *
     * @param in input directory for read and write in the output.zip.
     * @param z  the file which needs to be eventually archived.
     */
    private void checkDirectory(File in, ZipOutputStream z) {

        if (in.isDirectory()) {
            File[] list = in.listFiles();
            assert list != null;
            for (File item : list) {
                if (item.isDirectory()) {
                    checkDirectory(item, z);
                } else {
                    if (checkFile(item)) {
                        arh(item, z);
                    }
                }
            }
        }
    }

    /**
     * The method examines each file and compares the file extensions specified.
     *
     * @param file check the file.
     * @return flag.
     */
    private boolean checkFile(File file) {
        for (String sExt : ext) {
            if (sExt.equals(getFileExtension(file))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the extension from the check file.
     *
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
     * Method for start the progtam.
     *
     * @param args input string parametrs.
     */
    public static void main(String... args) {
        File outZip = new File(args[1]);
        File in = new File(args[3]);
        String[] s = args[5].split(",");

        ArchiverZipFile archiverZipFile = new ArchiverZipFile(outZip, s);
        try {
            archiverZipFile.init(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for open ZipOutputStream and start the method checkDirectory().
     *
     * @param in input Directory for out the file for zip.
     * @throws FileNotFoundException FileNotFoundException.
     */
    public void init(File in) throws FileNotFoundException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(arhZip))) {
            checkDirectory(in, zipOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Writes files into the archive.
     *
     * @param in the file to write to the archive.
     * @param z  the file which needs to be eventually archived.
     */
    private void arh(File in, ZipOutputStream z) {

        try (FileInputStream fileInputStream = new FileInputStream(in)) {

            byte[] buffer = new byte[1024];
            z.setLevel(Deflater.DEFAULT_COMPRESSION);
            ZipEntry zipEntry = new ZipEntry(in.getName());
            z.putNextEntry(zipEntry);
            int length;
            while ((length = fileInputStream.read(buffer)) > -1) {
                z.write(buffer, 0, length);
            }
            z.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

