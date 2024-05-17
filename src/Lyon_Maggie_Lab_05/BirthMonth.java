package Lyon_Maggie_Lab_05;

import java.util.Scanner;

public class BirthMonth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //declare month
        int month = 0;
        String trash = "";
        //output statement for month
        System.out.print("Enter the number of the month you were born in");
        // get input for month
        if(in.hasNextDouble()){
            month = in.nextInt();
            in.nextLine();
        }
        else{
            trash = in.nextLine();
            System.out.print("You entered an invalid entry\n");
        }
        //check if month is in range
        if (month > 0 && month < 13){
            //print month
            System.out.print("Your birth month is: "+ month);
        }
        else{
            //print month is wrong
            System.out.print("You entered an invalid birth month: " + month);
        }
    }
}
