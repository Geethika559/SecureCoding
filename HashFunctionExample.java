import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashFunctionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input string
        System.out.println("Enter the message to hash:");
        String message = scanner.nextLine();

        try {
            // Generating SHA-256 hash
            String sha256hex = hashString(message, "SHA-256");
            System.out.println("SHA-256 Hash: " + sha256hex);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 Algorithm not found");
        }
    }

    public static String hashString(String message, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] encodedhash = digest.digest(message.getBytes());

        // Converting the byte array to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
