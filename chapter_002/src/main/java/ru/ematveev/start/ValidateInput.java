package ru.ematveev.start;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 26.01.17.
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] ranges) {
        boolean invalide = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, ranges);
                invalide = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalide);
        return value;
    }
}
