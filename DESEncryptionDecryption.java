import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class DESEncryptionDecryption {

    public static void main(String[] args) {
        try {
            // Generate a random DES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();

            // Get user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the input string to be encrypted: ");
            String input = scanner.nextLine();

            // Encrypt the input string
            byte[] encryptedBytes = encrypt(input, secretKey);

            // Encode the encrypted bytes to base64 for easy display
            String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);

            // Display the encrypted string
            System.out.println("Encrypted string: " + encryptedBase64);

            // Decrypt the encrypted string
            String decryptedText = decrypt(Base64.getDecoder().decode(encryptedBase64), secretKey);

            // Display the decrypted string
            System.out.println("Decrypted string: " + decryptedText);
            
            // Close the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to encrypt the input string
    public static byte[] encrypt(String input, SecretKey key) throws Exception {
        // Initialize DES cipher
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, key);
        // Encrypt the input string
        return desCipher.doFinal(input.getBytes());
    }

    // Method to decrypt the encrypted bytes
    public static String decrypt(byte[] encryptedBytes, SecretKey key) throws Exception {
        // Initialize DES cipher
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.DECRYPT_MODE, key);
        // Decrypt the encrypted bytes
        byte[] decryptedBytes = desCipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}
