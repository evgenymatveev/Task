package exception;

/**
 * Class.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 02.02.17.
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
