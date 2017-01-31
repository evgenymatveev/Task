package ru.ematveev.start;

/**
 * Class.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 03.01.17.
 */
public class StubInput implements Input {
    /**
     * Array the answers.
     */
    private String[] answers;



    /**
     * Count of answers.
     */
    private int position = 0;

    /**
     * Constructor.
     * @param answers answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * implementation of class Input.
     * @param question question
     * @return answer.
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Method ask() for qustion.
     * @param question question.
     * @param ranges ranges.
     * @return int key.
     */
    public int ask(String question, int[] ranges) {
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
