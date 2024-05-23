package Ass02_Craps;

import java.util.Random;
import java.util.Scanner;

public class gameOfCraps {
    public static void main(String args[]) {
        //declare variables and generator and string in
        boolean done = false;
        boolean valid = false;
        boolean gameOver = false;
        Random generator = new Random();
        int die1;
        int die2;
        int crapsRoll;
        int i = 1;
        String choice = "";
        Scanner in = new Scanner(System.in);
        int point;

        do {
            done = false;
            gameOver = false;
            valid = false;
            die1 = generator.nextInt(6) + 1;
            die2 = generator.nextInt(6) + 1;
            crapsRoll = die1 + die2;
            System.out.print("You rolled a " + crapsRoll + "\n");

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.printf("You crapped out! Game over!\n");
                done = true;
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.printf("You won with a a natural!\n");
            } else {
                System.out.print(crapsRoll + " is now the point.\n");
                point = crapsRoll;
                do {
                    die1 = generator.nextInt(6) + 1;
                    die2 = generator.nextInt(6) + 1;
                    crapsRoll = die1 + die2;
                    System.out.print("You are trying for a point...\n");
                    if (crapsRoll == point) {
                        System.out.print("you made point! You win!\n");
                        gameOver = true;
                    } else if (crapsRoll == 7) {
                        System.out.printf("You rolled a 7 and lost.\n");
                        gameOver = true;
                    } else {
                        System.out.print("You rolled a " + crapsRoll + ". Try again!\n");
                    }
                } while (!gameOver);
            }
            do {
                System.out.print("Do you wish to continue? Y/N\n");
                choice = in.nextLine();
                if (!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))) {
                    System.out.print("You must enter Y/N! Try again!\n\n");
                } else if (choice.equalsIgnoreCase("N")) {
                    done = true;
                    valid = true;
                    System.out.print("Thanks for Playing!\n");
                    break;
                } else {
                    done = false;
                    valid = true;
                    i = 1;
                    System.out.print("Playing again! \n");
                }
            } while (!valid);
        } while (!done);
    }
}
