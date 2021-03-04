import java.util.Scanner;

public class Task2Arrays {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int max = array[0];
        for(int i = 1; i < size; i++) {
            if(array[i] > max) {
                max = array [i];
            }
        }
    System.out.println("Maximal value in an array is " + max);
    }
    
}