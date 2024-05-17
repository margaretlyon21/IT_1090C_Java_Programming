package Lyon_Maggie_Lab_05;
import java.util.Scanner;

public class TheaterKiosk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //declare price
        double price = 0;
        String trash = "";
        //output statement for price
        System.out.print("Enter the price of the item");
        // get input for price
        if(in.hasNextDouble()){
            price = in.nextDouble();
            in.nextLine();
        }
        else{
            trash = in.nextLine();
            System.out.print("You entered an invalid price\n");
        }
        //declare shipping cost
        double shippingCost;
        //calculate shipping cost
        if (price >= 100){
            shippingCost = price * 0.02;
        }
        else{
            shippingCost = 0;
        }
        //calculate total
        double totalCost = price + shippingCost;
        //output solutions
        System.out.print("The shipping cost is " + shippingCost + " and the total cost is " + totalCost);
    }

}
