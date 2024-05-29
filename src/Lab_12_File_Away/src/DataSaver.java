package Lab_12_File_Away.src;
import Lab_08_GetMethodical.SafeInput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String firstName;
        String lastName;
        String IDNumber;
        String email;
        int birthYear;
        boolean moreRecords = true;
        String csv;
        ArrayList<String> records = new ArrayList<>();
        do {
            firstName = SafeInput.getNonZeroLenString(in, "Enter your First name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            int idNumberInt = SafeInput.getRangedInt(in, "Enter your ID number ", 0, 999999);
            IDNumber = String.format("%06d", idNumberInt);            email = SafeInput.getNonZeroLenString(in, "Enter your email");
            birthYear = SafeInput.getRangedInt(in, "Enter your birth year ", 1900, 2024);
            csv = String.format("%s, %s, %s, %s, %d", firstName, lastName, IDNumber, email, birthYear);
            records.add(csv);
            moreRecords = SafeInput.getYNConfirm(in, "Do you want to input another record?");
        }while(moreRecords);

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

            for(String rec : records)
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
