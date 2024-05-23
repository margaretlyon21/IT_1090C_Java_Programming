package GettingLoopy;
import java.util.Random;
import java.util.Scanner;



public class Dieroller {
    public static void main(String args[]){
        //declare variables and generator and string in
        boolean done = false;
        boolean valid = false;
        Random generator = new Random();
        int num1;
        int num2;
        int num3;
        int i = 1;
        String choice = "";
        Scanner in = new Scanner(System.in);

        do{
            //generate numbers and print table
            num1 = generator.nextInt(6) + 1;
            num2 = generator.nextInt(6) + 1;
            num3 = generator.nextInt(6) + 1;
            System.out.printf("Roll " +i + " " + num1 + ", " + num2 + ", " + num3 + " Sum: " + (num1+num2+num3) + "\n");
            i++;

            //check if all dice are the same
            if (num1 == num2 && num2 == num3){
                //check if user wants to continue
                do {
                    System.out.print("Do you wish to continue? Y/N\n");
                    choice = in.nextLine();
                    if (!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))) {
                        System.out.print("You must enter Y/N! Try again!\n");
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
            }
        } while(!done);
    }
}
