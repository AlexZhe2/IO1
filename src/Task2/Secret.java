package Task2;

public class Secret {

   static String secretWord;
   static String secretKey;

    public static String getSecretWord() {
        return secretWord;
    }

    public static void setSecretWord(String secretWord) {
        Secret.secretWord = secretWord;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public static void setSecretKey(String secretKey) {
        if (secretKey.length()>secretWord.length()){
            System.out.println("\"secretKey\" не может быть длиннее чем \"secretWord\", по умолчанию значение \"secretKey\" установленно как \"secretWord\"  ");
            Secret.secretKey = secretWord;
        }else {Secret.secretKey = secretKey;}


    }
}
