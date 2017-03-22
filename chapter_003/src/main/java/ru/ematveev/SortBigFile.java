package ru.ematveev;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Matveev Evgeny.
 */
public class SortBigFile {
    /**
     * Курсор для установки места считывания итогового файла.
     */
    private long kursor = 0;
    /**
     * флаг для переключения записи между временными файлами.
     */
    private boolean flag = true;
    /**
     * флаг переключения между временными файлами при чтении их и сливания в итоговый файл.
     */
    private boolean flagTmp = true;
    /**
     * счетчик количества прочитанных строк итогового файла.
     */
    private int index = 0;
    /**
     * счетчик количества строк временного файла 1.
     */
    private int indexTmp1 = 0;
    /**
     * счетчик количества строк временного файла 2.
     */
    private int indexTmp2 = 0;
    /**
     * Курсор для установки места считывания временного файла 1.
     */
    private long kursorTmp1 = 0;
    /**
     * Курсор для установки места считывания временного файла 2.
     */
    private long kursorTmp2 = 0;
    /**
     * Длина файла для сортировки.
     */
    private long countR;
    /**
     * Длина файла итогового.
     */
    private long countW;
    /**
     * Шаг разбития на строки при временной сортировке.
     */
    private int p = 1;
    /**
     * Количество строк при первой разбивке.
     */
    private int n = 0;
    /**
     * Разделитель пути файла.
     */
    private String sr = File.separator;

    /**
     * Метод сортирует строки по возрастанию.
     *
     * @param source   файл для сортировки.
     * @param distance итоговый файл, в который нужно отсортировать.
     * @throws IOException IOException.
     */
    public void sort(File source, File distance) throws IOException {
        int count = 0;
        try (RandomAccessFile r = new RandomAccessFile(source, "r");
             RandomAccessFile w = new RandomAccessFile(distance, "rw");
             RandomAccessFile tmp1 = new RandomAccessFile(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "tmp1.txt", "rw");
             RandomAccessFile tmp2 = new RandomAccessFile(sr + "Users" + sr + "apple" + sr + "Documents" + sr + "JAVA" + sr + "J" + sr + "tmp2.txt", "rw")) {

            countR = r.length();
            countW = w.length();

            String line;
            while ((line = r.readLine()) != null) {
                count = count + 1;
                if (count % 2 != 0) {
                    tmp1.writeBytes((line) + "\n");
                    n++;
                } else {
                    tmp2.writeBytes((line) + "\n");
                    n++;
                }
            }
            r.close();

            while (p < n) {
                w.setLength(0);
                countW = 0;
                index = 0;
                kursorTmp1 = 0;
                kursorTmp2 = 0;
                merge(p, w, tmp1, tmp2);
                p = p * 2;
                kursor = 0;
                tmp1.setLength(0);
                tmp2.setLength(0);
                kursorTmp1 = 0;
                kursorTmp2 = 0;
                w.seek(0);
                index = 0;
                if (p < n) {
                    readW(w, p, tmp1, tmp2);
                    flag = true;
                } else {
                    break;
                }
            }
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод сливает в итоговый файл части, которые получает из метода mergePart().
     *
     * @param p    шаг разбития на строки при временной сортировке.
     * @param w    итоговый файл.
     * @param tmp1 временный файл 1.
     * @param tmp2 временный файл 2.
     * @throws IOException IOException.
     */
    private void merge(int p, RandomAccessFile w, RandomAccessFile tmp1, RandomAccessFile tmp2) throws IOException {
        while (countW <= countR) {
            mergePart(p, w, tmp1, tmp2);
            flagTmp = true;
            indexTmp1 = 0;
            indexTmp2 = 0;
        }
    }

    /**
     * Метод сливает определенное количество строк. Их количество зависит от параметра p.
     *
     * @param p    шаг разбития на строки при временной сортировке.
     * @param w    итоговый файл.
     * @param tmp1 временный файл 1.
     * @param tmp2 временный файл 2.
     * @throws IOException IOException.
     */
    private void mergePart(int p, RandomAccessFile w, RandomAccessFile tmp1, RandomAccessFile tmp2) throws IOException {
        String lineTmp1 = readTmp1(tmp1);
        String lineTmp2 = readTmp2(tmp2);
        int lengthTmp1 = lineTmp1.length();
        int lengthTmp2 = lineTmp2.length();

        for (int i = 0; i < p * 2; i++) {
            if ((lengthTmp1 <= lengthTmp2 && lengthTmp1 != 0 || !flagTmp && lengthTmp1 != 0) || flagTmp && lengthTmp2 == 0) {
                w.writeBytes(lineTmp1 + "\n");
                lengthTmp1 = 0;
                if (indexTmp1 < p) {
                    lineTmp1 = readTmp1(tmp1);

                    if (lineTmp1 == null) {
                        flagTmp = false;
                        lengthTmp1 = 0;
                    } else {
                        lengthTmp1 = lineTmp1.length();
                    }
                } else {
                    flagTmp = false;
                    lengthTmp1 = 0;
                }
            } else if ((lengthTmp1 > lengthTmp2 && lengthTmp2 != 0 || !flagTmp && lengthTmp2 != 0) || flagTmp && lengthTmp1 == 0) {
                w.writeBytes(lineTmp2 + "\n");
                lengthTmp2 = 0;
                if (indexTmp2 < p) {
                    lineTmp2 = readTmp2(tmp2);

                    if (lineTmp2 == null) {
                        lengthTmp2 = 0;
                        flagTmp = false;
                    } else {
                        lengthTmp2 = lineTmp2.length();
                    }
                } else {
                    flagTmp = false;
                    lengthTmp2 = 0;
                }
            }
        }
        countW = w.length();
    }

    /**
     * Метод читает временный файл 1.
     *
     * @param tmp1 временный файл 1.
     * @return возвращает прочитанную строку.
     * @throws IOException IOException.
     */
    private String readTmp1(RandomAccessFile tmp1) throws IOException {
        tmp1.seek(kursorTmp1);
        String line = tmp1.readLine();
        if (line == null) {
            return "";
        }
        kursorTmp1 = tmp1.getFilePointer();
        indexTmp1++;
        return line;
    }

    /**
     * Метод читает временный файл 2.
     *
     * @param tmp2 временный файл 2.
     * @return возвращает прочитанную строку.
     * @throws IOException IOException.
     */
    private String readTmp2(RandomAccessFile tmp2) throws IOException {
        tmp2.seek(kursorTmp2);
        String line = tmp2.readLine();
        if (line == null) {
            return "";
        }
        kursorTmp2 = tmp2.getFilePointer();
        indexTmp2++;
        return line;
    }

    /**
     * Метод запускает метод readLineW() для считывания строк итогого файла перед разбитием на временные файлы, анализирует и запускает метод для записи records().
     *
     * @param w    итоговый файл.
     * @param p    шаг разбития на строки при временной сортировке.
     * @param tmp1 временный файл 1.
     * @param tmp2 временный файл 2.
     * @throws IOException IOException.
     */
    private void readW(RandomAccessFile w, int p, RandomAccessFile tmp1, RandomAccessFile tmp2) throws IOException {
        while (kursor < w.length()) {
            for (int i = 0; i < p; i++) {
                w.seek(kursor);
                String s = readLineW(w);
                if (!Objects.equals(s, "")) {
                    records(s, tmp1, tmp2);
                    flagReg(index, p);
                } else {
                    break;
                }
            }
            flag = false;
            flagReg(index, p);
        }
    }

    /**
     * Метод читает строки итогового файла.
     *
     * @param w итоговый файл.
     * @return возвращает прочитанную строку.
     * @throws IOException IOException.
     */
    private String readLineW(RandomAccessFile w) throws IOException {
        w.seek(kursor);
        String line = w.readLine();
        kursor = w.getFilePointer();
        index++;
        return line;
    }

    /**
     * Метод записывает прочитанные строки из итогового файла в соответствующие временные файлы.
     *
     * @param line полученная строка после прочтения из метода readLineW().
     * @param tmp1 временный файл 1.
     * @param tmp2 временный файл 2.
     * @throws IOException IOException.
     */
    private void records(String line, RandomAccessFile tmp1, RandomAccessFile tmp2) throws IOException {
        if (flag) {
            tmp1.seek(kursorTmp1);
            tmp1.writeBytes((line) + "\n");
            kursorTmp1 = tmp1.getFilePointer();
        } else {
            tmp2.seek(kursorTmp2);
            tmp2.writeBytes((line) + "\n");
            kursorTmp2 = tmp2.getFilePointer();
        }
    }

    /**
     * Метод переключает поле "flag" для верной записи во временный файлы.
     *
     * @param index счетчик количества прочитанных строк итогового файла.
     * @param p     шаг разбития на строки при временной сортировке.
     */
    private void flagReg(int index, int p) {
        for (int i = 2; i < n; i = i + 2) {
            if (index == p * i) {
                flag = true;
            }
        }
    }
}


