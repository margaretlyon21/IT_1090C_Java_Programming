package Lab_6_Blocking_Input;

import java.util.Scanner;

import static java.lang.Math.pow;

public class RectangleInfo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double length = 0;
        double height = 0;
        double ppg = 0;
        String trash = "";
        boolean done = false;
        //check for valid length
        do {
            System.out.print("Enter the length of the rectangle: ");
            if (in.hasNextDouble()) {
                length = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You have to enter a valid length. Try again");
            }
        } while (!done);

        //check for valid height
        done = false;
        do {
            System.out.print("Enter the height of the rectangle: ");
            if (in.hasNextDouble()) {
                height = in.nextDouble();
                in.nextLine();
                done = true;
            } else {
                trash = in.nextLine();
                System.out.println("You have to enter a valid height. Try again");
            }
        } while (!done);

        //calculate the area
        double area = length * height;
        System.out.print("The area of the rectangle is " + area + "\n");

        //calculate the perimeter
        double perimeter = 2*length + 2*height;;
        System.out.print("The perimeter of hte rectangel is " + perimeter + "\n");

        //calculate the length of the diagonal
        double diaganol = pow((pow(length,2) + pow(height,2)), 0.5);
        System.out.print("The length of the diagonal is: " + diaganol + "\n");
    }
}
