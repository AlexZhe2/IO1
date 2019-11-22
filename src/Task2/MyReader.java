package Task2;

import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class MyReader extends FilterInputStream {
    public MyReader(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {

        String tempString = "";

        int j = 0;
        for (int i = 0; i < Secret.getSecretWord().length(); i++) {

            tempString = tempString + (char) (new String(b).charAt(i) ^ (Secret.getSecretKey().charAt(j)));
            j++;
            if (j == Secret.getSecretKey().length()) {
                j = 0;
            }
        }

        FileOutputStream fileOutputStream = null;

            fileOutputStream = new FileOutputStream("openWord.txt");
            fileOutputStream.write(tempString.getBytes());

        return super.read(b);
    }
}
