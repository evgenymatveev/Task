package ru.ematveev;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Matveev Evgeny.
 */
public class ArchiverZipFile {
    //
    public void checkDirectory(File z, File in, String [] s) {

            if(in.isDirectory()) {
                File[] list = in.listFiles();
                    for(File item : list) {
                        if(item.isDirectory()) {
                            checkDirectory(z, item, s);
                        } else {
                            if(checkFile(item, s)) {
                                arh(z, item);
                            } else {
                                break;
                            }
                        }
                    }
            }
    }
    //проверяет соответствует ли расширение заданным, если да - возвращает true
    private boolean checkFile(File file, String[] ext) {
        for (String sExt : ext) {
            if (sExt.equals(getFileExtension(file))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    //возвращает расширение у файла
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
            return "";
        }
    }
    //производит архивацию
    private void arh(File z, File in) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(z));
             FileInputStream fileInputStream = new FileInputStream(in);)
            {
                    ZipEntry zipEntry = new ZipEntry(in.getName());
                    zipOutputStream.putNextEntry(zipEntry);
                    byte[] buffer = new byte[1024];
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





