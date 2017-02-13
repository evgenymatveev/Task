package exception;

/**
 * Create exception when there is no shape at the position.
 * @author Matveev Evgeny.
 */
public class FigureNotFoundException extends Exception {
    /**
     * Method exception the input of the receiving line.
     * @param msg String which reports about a specific error (when on the position no figures.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
