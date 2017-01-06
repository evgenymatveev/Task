package ru.ematveev.start;

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
     * Method for the questions to the user.
     * @param question question
     * @return String
     */
    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }
}
