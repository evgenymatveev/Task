package exception;

/**
 * Create exception when there is no shape at the position.
 * @author Matveev Evgeny.
 */
public class OccupiedWayException extends Exception {
    /**
     * Method exception the input of the receiving line.
     * @param msg String which reports about a specific error (when the coordinate not true).
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
