package GettingLoopy;

public class partBNestedLoops {
    public static void main(String args[]){
        //5
        for (int i=0; i < 5; i++){
            for (int j=0; j <=i; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        //6
        for (int i=0; i < 5; i++){
            for (int j=5; j >i; j--){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        //7
        for (int i=0; i < 5; i++){
            for (int j=0; j < 5; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
