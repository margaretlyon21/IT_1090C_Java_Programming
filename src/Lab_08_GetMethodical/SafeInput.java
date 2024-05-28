package Lab_08_GetMethodical;

import java.util.Scanner;

/**
 *
 * @author wulft
 */
public class SafeInput 
{
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low    and integer lower value
     * @param high   an integer upper value
     * @return an integer representation of the string
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int result = 0;
        boolean done = false;
        String trash = "";
        do
        {            
            // Code and control logic to loop until validated
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if(pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine(); // clear input buffer
                if(result >= low && result <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + result);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int [" + low + " - " + high + "]: " + trash);
            }
       
        }while(!done);
        
        return result;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);
        return retString;
    }


    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer representaiton of the string
     */
    public static int getInt(Scanner pipe, String prompt){
        int value = 0;
        String trash = "";
        boolean done = false;
        //check for valid input
        do {
            System.out.println(prompt);
            if(pipe.hasNextInt()){
                value = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("You have to enter a valid integer. Try again\n");
            }
        } while (!done);
        return value;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double representation of the string
     */
    public static double getDouble(Scanner pipe, String prompt){
        double value = 0;
        String trash = "";
        boolean done = false;
        //check for valid input
        do {
            System.out.println(prompt);
            if(pipe.hasNextDouble()){
                value = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else{
                trash = pipe.nextLine();
                System.out.println("You have to enter a valid double. Try again\n");
            }
        } while (!done);
        return value;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low a double lower value
     * @param high a double upper value
     * @return a double representation of the string
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double result = 0;
        boolean done = false;
        String trash = "";
        do
        {
            // Code and control logic to loop until validated
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            if(pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                pipe.nextLine(); // clear input buffer
                if(result >= low && result <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + result);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double [" + low + " - " + high + "]: " + trash);
            }

        }while(!done);

        return result;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a boolean representing yes or no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        String choice ="";
        boolean valid = false;
        boolean answer = false;
        do {
            System.out.println(prompt + "Y/N");
            choice = pipe.nextLine();
            if (!(choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N"))) {
                System.out.print("You must enter Y/N! Try again!\n");
            } else if (choice.equalsIgnoreCase("N")) {
                valid = true;
                answer = false;
            } else {
                valid = true;
                answer = true;
            }
        } while (!valid);
        return answer;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx pattern in java string format to use for matching
     * @return a regEx string
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value = "";
        String trash = "";
        boolean gotAValue = false;
        do
        {
            // show the prompt
            System.out.println(prompt + ": ");
            // input the data
            value = pipe.nextLine();
            // test to see if it is correct
            if(value.matches(regEx))
            {
                // We have a match this String passes!
                gotAValue = true;
                pipe.nextLine();
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nInvalid input: " + value);
            }

        }while(!gotAValue);

        return value;
    }

    public static void prettyHeader(String msg){
            if (msg.length() > 60){
                System.out.print("The message is too long, sorry!");
                return;
            }
            for (int i = 0; i < 60; i ++){
                System.out.print("*");
            }
            System.out.print("\n***");
            for (int m = 0; m < (54 - msg.length())/2 ; m++ ){
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int n = (54 - msg.length())/2; n < 54 -msg.length(); n++){
                System.out.print(" ");
            }
            System.out.print("***\n");
            for (int j = 0; j < 60; j ++){
                System.out.print("*");

            }
    }
}
