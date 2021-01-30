import java.util.Scanner;
import java.util.Arrays;

public class Task7 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int count = 0;
        for(int i = 0; i < size; i++){
            if (array[i] % 2 != 0){
                count++;
            }
        }
    System.out.println("A number of an odd elements in tan array is " + count);
    }
}