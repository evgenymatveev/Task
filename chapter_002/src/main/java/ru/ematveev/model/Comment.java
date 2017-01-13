package ru.ematveev.model;

/**
 * Class Comment for create comments for items.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 09.01.17.
 */
public class Comment {
    /**
     * The number of possible coment in the array.
     */
    private int count = 10;
    /**
     * The aray for storage the comments.
     */
    private String[] arrayComment = new String[count];
    /**
     * The number of comments.
     */
    private int position = 0;

    /**
     * Method for adding the comments.
     * @param comment comment.
     */
    public void addComments(String comment) {
        this.arrayComment[position++] = comment;
    }

    /**
     * Method for the output to the console.
     * @param printer printer.
     */
    public void arrayOutComment(MenuTracker.IPrinter printer) {
        for (String comment : arrayComment) {
            if (comment != null) {
                printer.println(comment);
            } else {
                break;
            }
        }
    }
}
