import java.util.Scanner;
import java.util.Random;

public class Numbergame {

    // Function to play one round of the game and return the score
    static int playGame(int maxNumber, int maxTries) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int numberToGuess = r.nextInt(maxNumber) + 1;
        int guess;
        int triesLeft = maxTries;
        boolean guessed = false;

        System.out.println("\nEnter a number between 1 and " + maxNumber + "...");
        System.out.println("You have " + maxTries + " tries.");

        while (triesLeft > 0)
         {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if (guess == numberToGuess)
             {
                System.out.println("Correct Guess!! \t+10 points;");
                guessed = true;
                break;
            } else if (guess < numberToGuess)
             {
                System.out.println("Too low! Try a higher number.");
            } else
             {
                System.out.println("Too high! Try a lower number.");
            }

            triesLeft--;
            System.out.println("Tries left: " + triesLeft + "\n");
        }

        if (!guessed)
         {
            System.out.println("Out of tries! The correct number was: " + numberToGuess);
            return 0; 
        } 
        else 
        {
            int score = triesLeft * 10;
            System.out.println("Total Score: " + score + " points!\n");
            return score;
        }
        
    }

    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        int choice;
        int totalScore = 0;

        System.out.println("---Number Guess Game---");

        
        while (true) {
            System.out.println("\nChoose difficulty level based on range and number of tries:");
            System.out.println("1. Easy (1-20, 7 tries)");
            System.out.println("2. Medium (1-50, 5 tries)");
            System.out.println("3. Hard (1-100, 3 tries)");
            System.out.println("4. Exit Game");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    totalScore += playGame(20, 7);
                    break;
                case 2:
                    totalScore += playGame(50, 5);
                    break;
                case 3:
                    totalScore += playGame(100, 3);
                    break;
                case 4:
                    System.out.println("\n Total Score: " + totalScore);
                    System.out.println("Thanks for playing! ");
                    return; // exits the program
                default:
                    System.out.println("Invalid choice!.");
            }
        }
    }
}
