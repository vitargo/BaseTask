import java.util.Scanner;
import java.util.Arrays;

public class Task8Arrays {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int half = size/2;
        for(int i = 0; i < half; i++){
            if(size % 2 == 0){
                int temp = array[i];
                array[i] = array[i+half];
                array[i+half] = temp;
            }else{
                int temp = array[i];
                array[i] = array[i+half+1];
                array[i+half+1] = temp;
            }
        }
    System.out.println("An array after rotation: " + Arrays.toString(array));
    }
}