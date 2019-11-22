package Task1;

import java.io.*;

public class Main {


    static File file1 = new File("io1.txt");
    static File file3 = new File("io2.txt");
    static File file4 = new File("io3.txt");
    static File file5 = new File("io4.txt");

    static String text = "text";
    static int lenthPartOne = 10;
    static long getFilePointer;


    public static void main(String[] args) {


        try {
            writeWithBuffer(file3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeWithBuffer(file4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pinFiles(file3, file4, file5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeWithBuffer(File file) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            outputStream.write(readWithRandom(file).getBytes());
        }
    }


    public static String readWithRandom(File file) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(file1, "r");
        StringBuilder stringBuilder = new StringBuilder();

        if (file.equals(file3)) {
            for (int i = 0; i < lenthPartOne; i++) {
                stringBuilder.append(raf.readLine()).append("\n");
                getFilePointer = raf.getFilePointer();
            }
            text = stringBuilder.toString();
        }
        if (file.equals(file4)) {
            long lenthOffile = raf.length();

            raf.seek(getFilePointer);
            long check = 0;

            while (check != lenthOffile) {
                stringBuilder.append(raf.readLine()).append("\n");
                getFilePointer = raf.getFilePointer();
                check = getFilePointer;
            }
            text = stringBuilder.toString();
        }
        return text;
    }

    public static void pinFiles(File fileNo1, File fileNo2, File fileforSave) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileforSave);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            outputStream.write(readWithRandom2(fileNo1,fileNo2).getBytes());
        }
    }

    public static String readWithRandom2(File fileNo1, File fileNo2) throws IOException {
        RandomAccessFile rafNo1 = new RandomAccessFile(fileNo1, "rw");
        long lenthOffile = rafNo1.length();
        long check = 0;
        StringBuilder stringBuilderNo1 = new StringBuilder();
        while (check != lenthOffile) {
            stringBuilderNo1.append(rafNo1.readLine()).append("\n");
            getFilePointer = rafNo1.getFilePointer();
            check = rafNo1.getFilePointer();
        }

        RandomAccessFile rafNo2 = new RandomAccessFile(fileNo2, "rw");
        long lenthOffile2 = rafNo2.length();
        long check2 = 0;
        StringBuilder stringBuilderNo2 = new StringBuilder();
        while (check2 != lenthOffile2) {
            stringBuilderNo2.append(rafNo2.readLine()).append("\n");
            getFilePointer = rafNo2.getFilePointer();
            check2 = rafNo2.getFilePointer();
        }

        String text3 = stringBuilderNo1.append(stringBuilderNo2).toString();

        return text3;
    }
}
