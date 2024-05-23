package GettingLoopy;

public class partACountingLoops {
    public static void main(String args[]){
        // a loop that counts up by 1 from 0 to 30
        for(int i=0; i <= 30; i++){
            System.out.print(i + " ");
        }

        System.out.print("\n");

        // a loop that counts down by 1 from 30 to 0
        for(int i=30; i >=0; i--){
            System.out.print(i + " ");
        }

        System.out.print("\n");

        //a loop that counts up by 3 from 0 to 18
        for (int i = 0; i <= 18;){
            System.out.print(i + " ");
            i += 3;
        }

        System.out.print("\n");

        //a loop that counts down by 2 from 10 to 0
        for (int i = 10; i >= 0;){
            System.out.print(i + " ");
            i -= 2;
        }

    }
}
