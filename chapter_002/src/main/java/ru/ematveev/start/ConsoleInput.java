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
    public int ask(String question, int[] ranges) throws MenuOutException{
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for(int value : ranges){
            if (value == key){
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
