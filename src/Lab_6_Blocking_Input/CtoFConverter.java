package Lab_6_Blocking_Input;
import java.util.Scanner;

public class CtoFConverter {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        double celcius = 0;
        String trash = "";
        boolean done = false;
        //check for valid input
        do {
            System.out.print("enter the temperature in celcius: ");
            if(in.hasNextDouble()){
                celcius = in.nextDouble();
                in.nextLine();
                done = true;
            }
            else{
                trash = in.nextLine();
                System.out.println("You have to enter a valid temperature. Try again");
            }
        } while (!done);

        //convert to farenheight
        double farenheight = (celcius * 9/5) + 32;
        System.out.print("The temperature in farenheight is "+farenheight);
    }
}
