package Lab_6_Blocking_Input;

import java.util.Scanner;

public class FuelCosts {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double gallons = 0;
        double mpg = 0;
        double ppg = 0;
        String trash = "";
        boolean done = false;
        //check for valid gallons
        do {
            System.out.print("Enter the number of gallons in the tank: ");
            if (in.hasNextDouble()) {
                gallons = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You have to enter a valid number of gallons. Try again");
            }
        } while (!done);

        //check for valid mpg
        done = false;
        do {
            System.out.print("Enter the fuel efficiency of the car: ");
            if (in.hasNextDouble()) {
                mpg = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You have to enter a valid fuel efficiency. Try again");
            }
        } while (!done);

        //check for valid ppg
        done = false;
        do {
            System.out.print("Enter the price of a gallon of gas: ");
            if (in.hasNextDouble()) {
                ppg = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You have to enter a valid price. Try again");
            }
        } while (!done);

        //calculate the cost per 100 miles
        double hundredMiles = (ppg / mpg) * 100;
        System.out.print("The price to travel 100 miles is " + hundredMiles + "\n");

        //calculate how far the car can go
        double distance = (mpg * gallons);
        System.out.print("The car can travel " + distance + " miles on a tank of gas.");
    }
}
