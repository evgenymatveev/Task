package ru.ematveev.start;

/**
 * Interface.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 03.01.17.
 */
public interface Input {
    /**
     * Method for the questions to the user.
     * @param question question
     * @return String
     */
    String ask(String question);

    /**
     * Method for the questions to the user.
     * @param question question.
     * @param ranges ranges.
     * @return int.
     */
    int ask(String question, int[] ranges);
}
