package Lab_08_GetMethodical;
import java.util.Scanner;
public class Reggie {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String ssn = SafeInput.getRegExString(in, "Enter your SSN: ", "^\\d{3}-\\d{2}-\\d{4}$");
        String mNumber = SafeInput.getRegExString(in, "Enter your M number", "^(M|m)\\d{5}$");
        String menuChouce = SafeInput.getRegExString(in, "Enter your choice: ", "^[OoSsVvQq]$");
    }
}
