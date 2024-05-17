package Lyon_Maggie_Lab_05;
import java.util.Scanner;

public class TheaterKiosk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //declare age + wristband
        int age = 0;
        boolean wristband;
        String trash = "";
        //output statement for price
        System.out.print("Enter your age: ");
        // get input for age
        if(in.hasNextInt()){
            age = in.nextInt();
            in.nextLine();
        }
        else{
            trash = in.nextLine();
            System.out.print("You entered an invalid age\n");
        }
        if (age >= 21){
            System.out.print("You get a wristband!");
        }
    }

}
