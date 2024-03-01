import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HMACExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input string and secret key
        System.out.println("Enter the message for MAC generation:");
        String message = scanner.nextLine();
        System.out.println("Enter the secret key:");
        String secretKey = scanner.nextLine();

        try {
            // Generating HMAC SHA256 MAC
            String hmacSHA256 = generateHmacSHA256(message, secretKey);
            System.out.println("HMAC SHA256: " + hmacSHA256);
        } catch (Exception e) {
            System.err.println("Error generating HMAC SHA256: " + e.getMessage());
        }
    }

    public static String generateHmacSHA256(String data, String key) throws Exception {
        // Creating a secret key from the given string
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

        // Initializing and computing the MAC
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        // Encoding the MAC to Base64 for easier viewing
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
}
