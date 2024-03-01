import java.security.Key;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryptionDemo {

    private static final String ALGO = "AES";
    private static final byte[] AES_128BIT_KEY = getByteArray(16);

    public static void main(String[] args) throws Exception {

        Scanner cmd = new Scanner(System.in);
        System.out.println("Please enter data to be encrypted using AES algorithm");
        String content = cmd.nextLine();

        byte[] keyValue = AES_128BIT_KEY;

        String encrypted = encrypt(content, keyValue);
        String decrypted = decrypt(encrypted, keyValue);

        System.out.println("Data in Plain Text : " + content);
        System.out.println("Encrypted Text using AES algorithm: " + encrypted);
        System.out.println("Decrypted Text using AES algo: " + decrypted);
    }

    public static String encrypt(String data, byte[] keyValue) throws Exception {
        Key key = generateKey(keyValue);
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decrypt(String encryptedData, byte[] keyValue) throws Exception {
        Key key = generateKey(keyValue);
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    private static Key generateKey(byte[] value) throws Exception {
        return new SecretKeySpec(value, ALGO);
    }

    private static byte[] getByteArray(int bits) {
        byte[] value = new byte[bits];
        for (int i = 0; i < bits; i++) {
            value[i] = (byte) i;
        }
        return value;
    }
}
