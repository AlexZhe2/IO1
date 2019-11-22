package Task2;

import java.io.*;


public class Main {

    public static void main(String[] args) {

        Secret.setSecretWord("It was in July, 1805, and the speaker was the well-known Anna");
        Secret.setSecretKey("home");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("secWord.txt");
            MyWriter myWriter = new MyWriter(fileOutputStream);
            myWriter.write(Secret.secretWord.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("secWord.txt");
            MyReader myReader = new MyReader(fileInputStream);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            byte[] buf = new byte[128];
            int data;

            while ((data = myReader.read(buf)) > 0) {
                bout.write(buf, 0, data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



