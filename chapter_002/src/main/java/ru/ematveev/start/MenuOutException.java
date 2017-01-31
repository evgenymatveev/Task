package ru.ematveev.start;

/**
 * Class MenuOutException.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 26.01.17.
 */
public class MenuOutException extends RuntimeException {
    /**
     * MenuOutException.
     * @param msg msg.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
