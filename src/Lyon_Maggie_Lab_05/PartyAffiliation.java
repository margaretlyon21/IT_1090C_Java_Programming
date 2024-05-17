package Lyon_Maggie_Lab_05;

import java.util.Scanner;

public class PartyAffiliation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //declare party
        String party;
        //output statement for party
        System.out.print("Enter the party you identify as: Democrat(D), Republican (R), Independent (I), or Other");
        //input party
        party = in.nextLine();
        //if else for party + output statements
        if (party.equals("D")) {
            System.out.print("You got a democratic donkey!");
        } else if (party.equals("R")) {
            System.out.print("You got a republican elephant!");
        } else if (party.equals("I")) {
            System.out.print("You got an independent man!");
        } else {
            System.out.print("You got other...");
        }
    }
}
