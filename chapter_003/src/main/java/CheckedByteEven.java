import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Matveev Evgeny.
 */
public class CheckedByteEven {
    /**
     * The method checks that the byte stream written is an even number.
     * @param in the input stream.
     * @return booleat true if number is even and false if number is odd.
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            int x = Integer.parseInt(br.readLine());
                if ((x % 2) == 0 || x == 0) {
                    result = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return result;
    }
}
