import java.util.Scanner;

public class StringCharCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = scanner.nextLine();

        int vowels = 0, consonants = 0, digits = 0, special = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (!Character.isWhitespace(ch)) {
                special++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + special);
        scanner.close();
    }
}
