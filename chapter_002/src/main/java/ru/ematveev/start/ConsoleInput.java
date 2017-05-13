package ru.ematveev.start;

import java.util.List;
import java.util.Scanner;

/**
 * Class.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 03.01.17.
 */
public class ConsoleInput implements Input {
    /**
     * Scanner.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Method for the questions to the user.
     * @param question question
     * @return String
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Method ask() for question.
     * @param question question.
     * @param ranges List ranges.
     * @return int key.
     * @throws MenuOutException MenuOutException.
     */
    public int ask(String question, List<Integer> ranges) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : ranges) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
