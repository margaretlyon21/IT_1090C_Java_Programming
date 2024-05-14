package Lab4.Lab_04_Java_Variables;

public class Lab_04_01_SalesTax {
    public static void main(String[] args) {
        int price = 200;
        double salesTax = 0.05 * price;
        double totalPrice = price + salesTax;
        System.out.println("The sales tax is " + salesTax + " and the total price is " + totalPrice);
    }
}
