import java.util.Scanner;
import java.util.Arrays;

public class Task9SelectSort {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        for(int i = 0; i < size; i++){
            int min = i;
            for(int j = i+1; j < size; j++){
                if(array[j] < array[min]){
                    int temp = array[j];
                    array[j] = array[min];
                    array[min] = temp;
                }
            }        
        }
    System.out.println("An array sorted with Selection Sort: " + Arrays.toString(array));
    }
}