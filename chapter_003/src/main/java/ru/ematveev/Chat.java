package ru.ematveev;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Matveev Evgeny.
 */
public class Chat {
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);
    private String[] phrases = new String[]{"я знаю", "нет", "никогда", "возможно", "наверняка"};
    private boolean flag = true;
    private static Logger logger = Logger.getLogger(Chat.class);

    /**
     * Method reads messages from the console.
     */
    public void consoleInp() {
        String priv = "Добро пожаловать в чат!";
        System.out.println(priv);
        logger.info(priv);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (!checkPhrases(s) && !Objects.equals(s, "")) {
                checkFlag(flag);
                logger.info(s);
            } else {
                break;
            }
        }
    }

    /**
     * Method check the phrase.
     *
     * @param s input phrase for check.
     * @return boolean.
     */
    private boolean checkPhrases(String s) {
        switch (s) {
            case "стоп":
                flag = false;
                break;
            case "продолжить":
                flag = true;
                break;
            case "закончить":
                logger.info(s);
                return true;
            default:
                break;
        }
        return false;
    }

    /**
     * Method check the flag and output random phrase.
     *
     * @param flag is used for switching of program responses.
     */
    private void checkFlag(boolean flag) {
        if (flag) {
            String ph = createRandomPhrases();
            System.out.println(ph);
            logger.info(ph);
        }
    }

    /**
     * Method return the random phrases.
     *
     * @return random phrases.
     */
    private String createRandomPhrases() {
        String result = "";
        int r = random.nextInt(phrases.length);
        for (int i = 0; i < phrases.length; i++) {
            if (i == r) {
                result = phrases[i];
            }
        }
        return result;
    }

    /**
     * Method for start the programm.
     *
     * @param args String array paramerts. Not used.
     * @throws IOException IOException.
     */
    public static void main(String[] args) throws IOException {
        String sr = File.separator;
        File logPropertyFile = new File(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "log4j.properties");

        Config config = new Config(logPropertyFile);
        config.init();
        Chat chat = new Chat();
        chat.consoleInp();
    }
}























