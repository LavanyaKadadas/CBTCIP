import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;  // Maximum number of attempts allowed
        int secretNumber = random.nextInt(100) + 1;  // Generate random number between 1 and 100
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess (1-100): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("The secret number is higher than " + guess + ".");
            } else if (guess > secretNumber) {
                System.out.println("The secret number is lower than " + guess + ".");
            } else {
                guessedCorrectly = true;
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you did not guess the number. The correct number was " + secretNumber + ".");
        }

        scanner.close();
    }
}
