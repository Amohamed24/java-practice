import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;

        System.out.println("Hi there! Welcome to iGuess! What's your name: ");
        String name = scanner.nextLine();

        int limit = 4;
        int attempts = 0;
        boolean isRunning = true;

        while (isRunning && attempts < limit) {
            System.out.println("************************");
            System.out.println(name + "! Please guess a number between 1 and 10 (or type 'q' to quit):");
            System.out.println("************************");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing, " + name + "!");
                break;
            }

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
                continue;
            }

            attempts++;

            if (guess == randomNum) {
                System.out.println("Congrats! You guessed correctly in " + attempts + " attempts!");
                break;
            } else if (guess > randomNum) {
                System.out.println("Too high! Attempts left: " + (limit - attempts));
            } else {
                System.out.println("Too low! Attempts left: " + (limit - attempts));
            }
        }

        if (attempts >= limit) {
            System.out.println("You've run out of attempts! The number was: " + randomNum);
        }

        scanner.close();
    }
}



