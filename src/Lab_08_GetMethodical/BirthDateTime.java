package Lab_08_GetMethodical;
import java.util.Scanner;
public class BirthDateTime {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int year = SafeInput.getRangedInt(in, "Enter the year you were born", 1950, 2015);
        int month = SafeInput.getRangedInt(in, "Enter the month you were born", 0, 12);
        int day = 0;
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                day = SafeInput.getRangedInt(in,"Enter the day you were born", 0, 31);
                break;
            }
            case 2:{
                day = SafeInput.getRangedInt(in, "Enter the day you were born", 0, 28);
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11:{
                day = SafeInput.getRangedInt(in, "Enter the day you were born", 0, 30);
                break;
            }
        }
        int hour = SafeInput.getRangedInt(in, "Enter the hour you were born", 0,24);
        int minute = SafeInput.getRangedInt(in, "Enter the minute you were born", 0, 59);
        System.out.println("You were born " + year + "/" + month + "/" + day + " " + hour + ":" + minute);

    }
}
