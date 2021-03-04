import java.util.Scanner;

public class Task1Arrays {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int min = array[0];
        for(int i = 1; i < size; i++) {
            if(array[i] < min) {
                min = array [i];
            }
        }
    System.out.println("Minimal value in an array is " + min);
    }
    
}