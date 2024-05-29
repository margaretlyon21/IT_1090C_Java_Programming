package Lab_11_List_Maker;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab_11_List_Maker {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean sure = false;
        ArrayList<String> myArrList = new ArrayList<>();
        do{
            showListandMenu(myArrList);
            String choice = SafeInput.getRegExString(in, "Enter your choice", "^[AaDdIiPpQq]");
            switch (choice){
                case "A":
                case "a": {
                    addItem(myArrList);
                    break;
                }
                case "D":
                case "d": {
                    deleteItem(myArrList);
                    break;
                }
                case "I":
                case "i":{
                    insertItem(myArrList);
                    break;
                }
                case "P":
                case "p":{
                    showList(myArrList);
                    break;
                }
                case "Q":
                case "q": {
                    sure = SafeInput.getYNConfirm(in, "Are you sure?");
                }


            }
        }while(!sure);

    }

    private static void displayOptions(){
        System.out.println("A - Add and item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print (i.e. display) the list");
        System.out.println("Q - Quit the program");
    }

    private static void showListandMenu(ArrayList<String> myList){
        for (int i = 0; i < myList.size(); i++ ){
            System.out.println((i+1) + ". " + myList.get(i));
        }
        displayOptions();
    }

    private static void showList(ArrayList<String> myList){
        for (int i = 0; i < myList.size(); i++ ){
            System.out.println(i + ". " + myList.get(i));
        }
    }

    private static void addItem(ArrayList<String> myList){
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "Enter the string you would like to add to the list");
        myList.add(item);
    }

    private static void deleteItem(ArrayList<String> myList){
        Scanner in = new Scanner(System.in);
        int item = SafeInput.getRangedInt(in, "Which item would you like to remove?", 1, myList.size());
        myList.remove((item-1));
    }

    private static void insertItem(ArrayList<String> myList){
        Scanner in = new Scanner(System.in);
        int location = SafeInput.getRangedInt(in, "Where would you like to insert the item?", 1, myList.size());
        String item = SafeInput.getNonZeroLenString(in, "What item would you like to insert");
        myList.add((location - 1), item);
    }
}
