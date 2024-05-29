package Lab_09_ArrayStuff;
import java.util.Scanner;
import java.util.Random;

public class Lab_09_ArrayStuff {
    public static void main(String args[]){
        int dataPoints[] = new int[100];
        Random rnd = new Random();
        int val;
        for (int i = 0; i < dataPoints.length; i++){
            val = rnd.nextInt(100) + 1; // gives a value from 1 to 100
            dataPoints[i] = val;
        }
        for (int i = 0; i < dataPoints.length; i++){
            System.out.print(dataPoints[i] + "|");
        }
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++){
            sum += dataPoints[i];
        }
        double average = sum / dataPoints.length;
        System.out.println("\nThe sum of the random array dataPoints is " + sum);
        System.out.println("The average of the random array dataPoints is " + average);

        Scanner in = new Scanner(System.in);
        int input = SafeInput.getRangedInt(in, "Enter a integer value", 1,100);
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++){
            if (dataPoints[i] == input){
                count++;
            }
        }
        System.out.println("the value " + input + " was found " + count + " times in dataPoints.");


        int value = SafeInput.getRangedInt(in, "Enter a integer value", 1,100);
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++){
            if (dataPoints[i] == value){
                position = i;
                System.out.println("the value " + value + " was found at position " + position + " in dataPoints.");
                break;
            }
        }
        if (position == -1){
            System.out.println("the value " + value + " was not found in dataPoints.");
        }

        int min = 100;
        int max = 0;
        for (int i = 0; i < dataPoints.length; i++){
            if (dataPoints[i] > max){
                max = dataPoints[i];
            }
            if (dataPoints[i] < min){
                min = dataPoints[i];
            }
        }
        System.out.println("The max in dataPoints is " + max + " and the minimum is " + min);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

    }

    public static double getAverage(int values[]){
        int sum = 0;
        for (int i = 0; i < values.length; i++){
            sum += values[i];
        }
        double average = sum / values.length;
        return average;
    }
}
