package ru.ematveev;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;

/**
 * @author Matveev Evgeny.
 */
public class DeleteWord {
    /**
     * Method delete world-abuse.
     *
     * @param in    the input stream consists of the string.
     * @param out   the output stream consists of the string after the removal of the abuse words.
     * @param abuse the abuse which need delete.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String s;

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(in))) {
            while ((s = rd.readLine()) != null) {
                for (String str : abuse) {
                    if (s.contains(str)) {
                        s = s.replace(str, "");
                    }
                }
                out.write(s.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
