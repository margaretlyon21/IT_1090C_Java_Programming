package Ass01_RockPaperScissors;

import java.util.Scanner;

public class Ass01_RockPaperScissors {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String A = "";
        String B = "";
        String trash = "";
        boolean correct = false;
        String choice = "";
        boolean done = false;
        //check for valid length
        do {
            do {
                System.out.print("Player A: enter your choice (R,P,S): ");
                A = in.nextLine();
                if (!(A.equals("R") || A.equals("P") || A.equals("S"))) {
                    System.out.print("You must enter R, P, or S! Try again!\n");
                } else {
                    done = true;
                }
            } while (!done);
            done = false;
            do {
                System.out.print("Player B: enter your choice (R,P,S): ");
                B = in.nextLine();
                if (!(B.equals("R") || B.equals("P") || B.equals("S"))) {
                    System.out.print("You must enter R, P, or S! Try again!\n");
                } else {
                    done = true;
                }
            } while (!done);
            if (A.equals("R") && B.equals("S")) {
                System.out.print("Rock breaks Scissors! Player A wins!\n");
            } else if (A.equals("S") && B.equals("R")) {
                System.out.print("Rock breaks Scissors! Player B wins!\n");
            } else if (A.equals("R") && B.equals("P")) {
                System.out.print("Paper covers rock! Player B wins!\n");
            } else if (A.equals("P") && B.equals("R")) {
                System.out.print("Paper covers rock! Player A wins!\n");
            } else if (A.equals("P") && B.equals("S")) {
                System.out.print("Scissors cut paper! Player B wins!\n");
            } else if (A.equals("S") && B.equals("P")) {
                System.out.print("Scissors cut paper! Player A wins!\n");
            } else {
                System.out.print(A + " vs " + B + ". Its a tie!\n");
            }
            done = false;
            //check for valid input
                do {
                    System.out.print("Do you wish to continue? Y/N\n");
                    choice = in.nextLine();
                    if (!(choice.equals("Y") || choice.equals("N"))) {
                        System.out.print("You must enter Y/N! Try again!\n");
                    } else if (choice.equals("N")) {
                        done = true;
                        System.out.print("Thanks for Playing!\n");
                        break;
                    } else {
                        break;
                    }
                } while (!done);
            } while (!done);
        }
    }
