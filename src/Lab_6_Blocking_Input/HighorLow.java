package Lab_6_Blocking_Input;

import java.util.Scanner;
import java.util.Random;

public class HighorLow {
    public static void main(String args[]) {
        Random generator = new Random();  // I usually call it rnd or gen
        int num = generator.nextInt(10) + 1;

        Scanner in = new Scanner(System.in);
        int guess = 0;
        String trash = "";
        boolean correct = false;
        boolean done = false;
        //check for valid length
        do {
            do {
                System.out.print("Enter your guess (1-10): ");
                if (in.hasNextInt()) {
                    guess = in.nextInt();
                    in.nextLine();
                    done = true;
                } else {
                    trash = in.nextLine();
                    System.out.println("You have to enter a valid guess. Try again\n");
                }
            } while (!done);
            if (guess == num) {
                correct = true;
                System.out.print("Correct!");
            } else if (guess > num) {
                System.out.print("The number is lower than your guess\n");
            } else {
                System.out.print("The number is higher than your guess\n");
            }
        } while (!correct);
    }
}
