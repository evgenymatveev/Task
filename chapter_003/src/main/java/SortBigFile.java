import java.io.*;
import java.util.Objects;

/**
 * @author Matveev Evgeny.
 */
public class SortBigFile {
    private long kursor = 0;
    private boolean flag = true;
    private boolean flagTmp = true;
    private int index = 0;
    private int indexTmp1 = 0;
    private int indexTmp2 = 0;
    private long kursorTmp1 = 0;
    private long kursorTmp2 = 0;
    private long countR;
    private long countW;
    private int p = 1;
    private int n = 0;

    public void sort(File source, File distance) throws IOException {
        int count = 0;
        try (RandomAccessFile r = new RandomAccessFile(source, "r");
             RandomAccessFile w = new RandomAccessFile(distance, "rw");
             RandomAccessFile tmp1 = new RandomAccessFile("tmp1.txt", "rw");
             RandomAccessFile tmp2 = new RandomAccessFile("tmp2.txt", "rw")) {

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

    private void merge(int p, RandomAccessFile w, RandomAccessFile tmp1, RandomAccessFile tmp2) throws IOException {
        while (countW <= countR) {
            mergePart(p, w, tmp1, tmp2);
            flagTmp = true;
            indexTmp1 = 0;
            indexTmp2 = 0;
        }
    }

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

    private String readLineW(RandomAccessFile w) throws IOException {
        w.seek(kursor);
        String line = w.readLine();
        kursor = w.getFilePointer();
        index++;
        return line;
    }

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

    private void flagReg(int index, int p) {
        for (int i = 2; i < n; i = i + 2) {
            if (index == p * i) {
                flag = true;
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        File fR = new File("textR.txt");
//        File fW = new File("textW.txt");
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fR, false))) {
//            writer.write("Евгений" + "\n"
//                    + "Александр" + "\n"
//                    + "Света" + "\n"
//                    + "Юля" + "\n"
//                    + "Вячеслава" + "\n"
//                    + "Нина" + "\n"
//                    + "Оля" + "\n"
//                    + "Николай" + "\n"
//                    + "Даниил" + "\n"
//                    + "Петр" + "\n"
//                    + "Роберт" + "\n"
//                    + "Александр" + "\n"
//                    + "Света" + "\n"
//                    + "Юля" + "\n"
//                    + "Вячеслава" + "\n"
//                    + "Александр" + "\n"
//                    + "Света" + "\n"
//                    + "Юля" + "\n"
//                    + "Вячеслава" + "\n"
//                    + "Александр" + "\n"
//                    + "Света" + "\n"
//                    + "Юля" + "\n"
//                    + "Вячеслава" + "\n"
//                    + "Александр" + "\n"
//                    + "Света" + "\n"
//                    + "Юля" + "\n"
//                    + "Вячеслава" + "\n"
//                    + "Влада" + "\n"
//                    + "Анастасия" + "\n"
//                    + "Татьяна" + "\n"
//                    + "Родион" + "\n"
//                    + "Нина" + "\n"
//                    + "Оля" + "\n"
//                    + "Николай" + "\n"
//                    + "Даниил" + "\n"
//                    + "Петр" + "\n"
//                    + "Роберт" + "\n"
//                    + "Влада" + "\n"
//                    + "Сергей" + "\n"
//                    + "Вячеслав" + "\n"
//                    + "Иннокентий" + "\n"
//            );
//            writer.flush();
//            SortBigFile sortBigFile = new SortBigFile();
//            sortBigFile.sort(fR, fW);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}


