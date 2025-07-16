import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordChecker {

    // Define character sets
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+<>?";
    private static final int STRONG_PASSWORD_LENGTH = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to check: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);

        if (strength.equals("Weak")) {
            System.out.println("\nHere are some suggested strong passwords:");
            for (int i = 0; i < 3; i++) {
                System.out.println(" - " + generateStrongPassword());
            }
        }

        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()\\-_=+<>?].*")) score++;

        if (score <= 2) return "Weak";
        else if (score == 3 || score == 4) return "Moderate";
        else return "Strong";
    }

    public static String generateStrongPassword() {
        SecureRandom random = new SecureRandom();
        String allChars = UPPER + LOWER + DIGITS + SPECIAL;

        StringBuilder password = new StringBuilder();

        // Ensure one of each required character type
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // Fill remaining characters randomly
        for (int i = 4; i < STRONG_PASSWORD_LENGTH; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle characters (optional but more secure)
        return shuffleString(password.toString(), random);
    }

    private static String shuffleString(String input, SecureRandom random) {
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}

