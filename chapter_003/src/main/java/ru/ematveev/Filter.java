package ru.ematveev;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Matveev Evgeny.
 */
public class Filter implements FileFilter {
    private String[] ext;

    Filter(String ext)
    {
        this.ext = ext.split(",");
    }
    private String getExtension(File pathname)
    {
        String filename = pathname.getPath();
        int i = filename.lastIndexOf('.');
        if ((i > 0) && (i < filename.length()-1)) {
            return filename.substring(i+1).toLowerCase();
        }
        return "";
    }
    public boolean accept(File pathname)
    {
        if (!pathname.isFile())
            return false;
        String extension = getExtension(pathname);
        for (String e : ext) {
            if (e.equalsIgnoreCase(extension))
                return true;
        }
        return false;
    }
}
