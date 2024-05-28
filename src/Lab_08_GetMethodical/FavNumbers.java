package Lab_08_GetMethodical;
import java.util.Scanner;

public class FavNumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int favInt = SafeInput.getInt(in, "Enter your favorite integer");
        double favDouble = SafeInput.getDouble(in, "Enter your favorite double");
        System.out.print("Your favorite int is " + favInt + " and your favorite double is " + favDouble);
    }
}
