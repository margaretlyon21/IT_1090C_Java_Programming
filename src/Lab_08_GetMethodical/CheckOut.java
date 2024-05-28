package Lab_08_GetMethodical;
import java.util.Scanner;
public class CheckOut {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        double total = 0;
        do {
            double price = SafeInput.getRangedDouble(in, "Enter the price of the item", 0.5, 10.0);
            total += price;
            done = !(SafeInput.getYNConfirm(in, "Do you have more items to scan?"));
        } while (!done);
        System.out.printf("The total cost is %.2f", total);
    }
}
