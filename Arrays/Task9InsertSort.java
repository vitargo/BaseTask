import java.util.Scanner;
import java.util.Arrays;

public class Task9InsertSort {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        for(int i = 1; i < size; i++){
            int key = array[i];
            int j = i-1;
            while(j >-1 && array[j] > key){
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
    System.out.println("An array sorted with Insertion Sort: " + Arrays.toString(array));
    }
}