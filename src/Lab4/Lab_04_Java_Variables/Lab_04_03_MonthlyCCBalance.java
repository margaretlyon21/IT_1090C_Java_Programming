package Lab4.Lab_04_Java_Variables;

public class Lab_04_03_MonthlyCCBalance {
    public static void main(String[] args) {
        double balance = 5000;
        double interestRate = 1.17;
        System.out.println("The amount due after one month is " + (balance*interestRate) + " and the amount due after two months is " + ((balance*interestRate)*interestRate));
    }
}
