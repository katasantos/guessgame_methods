package com.santos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int guess = 0, tries = 0;
        int randomNumber = 0;
        randomNumber = randomizeNumber(randomNumber);

        do {
            do {
                System.out.print("\nGuess the number!: ");
                guess = Integer.parseInt(br.readLine());
            } while (numIsOk(guess) == false);
            tries++;

            validateGuess(guess, randomNumber);

    }while(exceedNumberOfTries(tries) == false && guessStatus(guess,randomNumber) == false);

    }

    public static int randomizeNumber(int number) {
        Random r = new Random();
        return number = r.nextInt(100 - 1 + 1) + 1;
    }

    public static boolean guessStatus(int guess, int randomNum){
        if(guess == randomNum)
            return true;
        return false;
    }

    public static void validateGuess(int guess, int randomNum) {
        if (guess == randomNum) {
            System.out.println("You guessed the number!");
        } else if (guess > randomNum) {
            System.out.print("Lower!");
        } else if (guess < randomNum) {
            System.out.print("Higher!");
        }
    }

    public static boolean numIsOk(int guess) {
        if (guess > 100 || guess < 0) {
            System.out.println("\fNumber must be between 0-100");
            return false;
        }
        return true;
    }

    public static boolean exceedNumberOfTries(int tries){
        if (tries < 5) {
            return false;
        }
        System.out.println("\f\n\nExceeded number of tries!");
        return true;
    }
}
