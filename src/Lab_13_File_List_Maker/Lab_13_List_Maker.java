package Lab_13_File_List_Maker;

import Lab_11_List_Maker.SafeInput;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Lab_13_List_Maker {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean sure = false;
        boolean dirty = false;
        boolean opened = false;
        ArrayList<String> myArrList = new ArrayList<>();
        do{
            showListandMenu(myArrList);
            String choice = SafeInput.getRegExString(in, "Enter your choice", "^[AaDdIiVvQqMmOoSsCc]");
            switch (choice){
                //add an item
                case "A":
                case "a": {
                    addItem(myArrList);
                    dirty = true;
                    break;
                }
                //delete an item
                case "D":
                case "d": {
                    deleteItem(myArrList);
                    dirty = true;
                    break;
                }
                //insert an item
                case "I":
                case "i":{
                    insertItem(myArrList);
                    dirty = true;
                    break;
                }
                //View the list
                case "V":
                case "v":{
                    showList(myArrList);
                    break;
                }
                //quit the program
                case "Q":
                case "q": {
                    sure = SafeInput.getYNConfirm(in, "Are you sure?");
                    boolean save;
                    if (dirty == true && opened == true){
                        save = SafeInput.getYNConfirm(in,"Do you want to save the updated list?");
                        if (save == true){
                            saveList(myArrList);
                        }
                    } else if (dirty == true){
                        save = SafeInput.getYNConfirm(in,"Do you want to save the list (Y) or abandon it (N)?");
                        if (save == true){
                            saveList(myArrList);
                        }
                    }
                    sure = true;
                    break;
                }
                //move an item
                case "M":
                case "m":{
                    moveItem(myArrList);
                    dirty = true;
                    break;
                }
                //Open a list file
                case "O":
                case "o":{
                    if (dirty == true){
                        boolean save = SafeInput.getYNConfirm(in,"You already have an unsaved list. Do you want to save it (Y) or abandon it?");
                        if (save){
                            saveList(myArrList);
                        }
                    }
                    myArrList = openItem();
                    opened = true;
                    break;
                }
                //save the current item to the disk
                case "S":
                case "s":{
                    saveList(myArrList);
                    System.out.println("The list has been saved to the disk.");
                    dirty = false;
                    break;
                }
                //clear - remove all elements from current list
                case "C":
                case "c":{
                    clearList(myArrList);
                    dirty = true;
                    break;
                }

            }
        }while(!sure);

    }

    private static void displayOptions(){
        System.out.println("A - Add and item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("V - View (i.e. display) the list");
        System.out.println("M - Move an item");
        System.out.println("O - Open a list file from disk");
        System.out.println("S - Save the currect list file to disk");
        System.out.println("C - Clear all elements from current list");
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

    private static void moveItem(ArrayList<String> myList){
        Scanner in = new Scanner(System.in);
        int itemIndex = SafeInput.getRangedInt(in, "Which item do you want to move?", 1, myList.size());
        int moveTo = SafeInput.getRangedInt(in, "Where would you like to move it to?",1, myList.size());
        String item = myList.get(itemIndex-1);
        myList.remove(itemIndex-1);
        myList.add(moveTo-1, item);
    }
    private static ArrayList<String> openItem(){
        JFileChooser chooser = new JFileChooser();
        Scanner inFile = null;
        String line;
        ArrayList<String> myList = new ArrayList<>();
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);
                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    myList.add(line);
                }


            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
        return myList;
    }

    private static void clearList(ArrayList<String> myList){
        myList.clear();
    }

    private static void saveList(ArrayList<String> myList) {
            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.getPath() + "/src","data.txt");
            try
            {
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                OutputStream out =
                        new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer =
                        new BufferedWriter(new OutputStreamWriter(out));

                // Finally can write the file LOL!

                for(String rec : myList)
                {
                    writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                    // 0 is where to start (1st char) the write
                    // rec. length() is how many chars to write (all)
                    writer.newLine();  // adds the new line

                }
                writer.close(); // must close the file to seal it and flush buffer
                System.out.println("Data file written to: " + file.toAbsolutePath());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

    }

}
