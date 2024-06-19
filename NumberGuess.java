import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 10;
        
        int totalScore = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Advanced Number Guessing Game!");
        
        while (playAgain) {
            int generatedNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            System.out.println("New game! Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
            
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Attempt #" + (attempts + 1) + ": Enter your guess: ");
                
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input from scanner
                    continue;
                }
                
                if (userGuess < MIN_RANGE || userGuess > MAX_RANGE) {
                    System.out.println("Your guess is out of the valid range (" + MIN_RANGE + " to " + MAX_RANGE + "). Try again.");
                    continue;
                }
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    int points = MAX_ATTEMPTS - attempts;
                    totalScore += points;
                    System.out.println("Points earned for this round: " + points);
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you did not guess the number. It was: " + generatedNumber);
            }

            roundsPlayed++;
            System.out.println("Your current score: " + totalScore);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing! Total rounds played: " + roundsPlayed + ", Final score: " + totalScore);
            }
        }

        scanner.close();
    }
}
