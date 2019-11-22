package Task2;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class MyWriter extends FilterOutputStream {

    public MyWriter(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {

        String tempString = "";

        int j = 0;
        for (int i = 0; i < Secret.getSecretWord().length(); i++) {
            tempString = tempString + (char) ((Secret.getSecretWord().charAt(i)) ^ (Secret.getSecretKey().charAt(j)));
            j++;
            if (j == Secret.getSecretKey().length()) {
                j = 0;
            }
        }
        super.write(tempString.getBytes());
    }
}
