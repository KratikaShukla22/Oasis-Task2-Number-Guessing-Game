package com.oasis.numberguessing;
import java.util.ArrayList;
import java.util.Scanner;

                public class NumberGuessingGame {
                    private int randomNumber;
                    private int attempts;
                    void generateNumber(int maxNumber) {
                        randomNumber = (int)(Math.random() * maxNumber) + 1;
                    }
                    public static void main(String[] args) {
                        com.oasis.numberguessing.NumberGuessingGame game = new com.oasis.numberguessing.NumberGuessingGame();
                        Scanner sc = new Scanner(System.in);
                        ArrayList<String> history = new ArrayList<>();

                        int round = 0;
                        int wins = 0;
                        int score=0;
                        int totalScore = 0;
                        String difficulty;
                        int maxNumber;
                        int maxAttempts;
                        while (true) {
                            round++;
                            System.out.println("\n========== ROUND " + round + " ==========");
                            System.out.println("Choose difficulty:");
                            System.out.println("1. Easy");
                            System.out.println("2. Medium");
                            System.out.println("3. Hard");

                            int choice = sc.nextInt();
                            if (choice == 1) {
                                difficulty = "Easy";
                            } else if (choice == 2) {
                difficulty = "Medium";
            } else if (choice == 3) {
                difficulty = "Hard";
            }  else {
            System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            round--;
            continue;
        }
            if (difficulty.equals("Easy")) {
                maxNumber = 50;
                maxAttempts = 10;
            } else if (difficulty.equals("Medium")) {
                maxNumber = 100;
                maxAttempts = 7;
            } else {
                maxNumber = 200;
                maxAttempts = 5;
            }
            System.out.println("Difficulty: " + difficulty);
            System.out.println("You have " + maxAttempts + " attempts.");
            game.attempts = 0;
            game.generateNumber(maxNumber);

            System.out.println("Round " + round);

            System.out.println("Guess the number between 1 and " + maxNumber + ":");

            boolean won = false;

            while (game.attempts < maxAttempts) {

                int guess = sc.nextInt();

                if (guess < 1 || guess >maxNumber) {
                    System.out.println("Please enter a number between 1 and " + maxNumber + ":");
                    continue;
                }

                game.attempts++;

                if (guess > game.randomNumber) {
                    System.out.println("Too High!");
                } else if (guess < game.randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct!");
                    System.out.println("You guessed it in " + game.attempts + " attempts!");
                    won = true;
                    wins++;
                    score = (maxAttempts - game.attempts + 1) * 10;
                    System.out.println("Your score: " + score);
                    totalScore += score;
                    break;
                }
            }

            if (!won) {
                System.out.println("Game Over!");
                System.out.println("You used all " + maxAttempts + " attempts.");
                System.out.println("The number was: " + game.randomNumber);
            }

            System.out.println("Round " + round + " completed.");
            if (won) {
                history.add("Round " + round + " - Won in " + game.attempts + " attempts - Score: " + score);
            } else {
                history.add("Round " + round + " - Lost");
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = sc.next();

            if (playAgain.equalsIgnoreCase("no")) {

                System.out.println("\nGame History:");

                for (String result : history) {
                    System.out.println(result);
                }
                System.out.println("Total wins: " + wins + " out of " + round + " rounds.");
                System.out.println("Total score: " + totalScore);
                break;
            }
        }
    }
}


