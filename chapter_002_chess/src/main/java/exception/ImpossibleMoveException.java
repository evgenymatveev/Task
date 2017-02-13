package exception;

/**
 * Create exception when there is no shape at the position.
 * @author Matveev Evgeny.
 */
public class ImpossibleMoveException extends Exception {
    /**
     * Method exception the input of the receiving line.
     * @param msg String which reports about a specific error (when you can't make a move).
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
