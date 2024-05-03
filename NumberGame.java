// TASK 1 =NUMBER GAME ============>>>>>>>
// 1. Generate a random number within a specified range, such as 1 to 100.
// 2. Prompt the user to enter their guess for the generated number.
// 3. Compare the user's guess with the generated number and provide feedback on whether the guess
// is correct, too high, or too low.
// 4. Repeat steps 2 and 3 until the user guesses the correct number.
// You can incorporate additional details as follows:
// 5. Limit the number of attempts the user has to guess the number.
// 6. Add the option for multiple rounds, allowing the user to play again.
// 7. Display the user's score, which can be based on the number of attempts taken or rounds won.





import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min_num = 1;
        int max_num = 100;
        int chances = 10;
        int final_score = 0;
        boolean playAgain = true;

        System.out.println("Welcome in the Number Game!");
        System.out.println("You have " + chances + " chances to guess the number between " + min_num + " and " + max_num + ".");

        while (playAgain) {
            int randomNumber = getRandomNumber(min_num, max_num);
            boolean guessedCorrectly = false;

            for (int i = 0; i < chances; i++) {
                System.out.print("Attempt " + (i + 1) + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulation! You guessed the number!");
                    guessedCorrectly = true;
                    final_score += 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, You have used all your chances. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = sc.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! Your final_score is: " + final_score);
        sc.close();
    }

    public static int getRandomNumber(int min_num, int max_num) {
        return (int) (Math.random() * (max_num - min_num + 1) + min_num);
    }
}