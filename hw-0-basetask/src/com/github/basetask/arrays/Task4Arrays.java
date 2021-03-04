import java.util.Scanner;

public class Task4Arrays {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int indexmax = 0;
        for(int i = 1; i < size; i++){
            if(array[i] > array[indexmax]){
                indexmax = i;
            }
        }
    System.out.println("An index of the maximal value in an array is " + indexmax);
    }
    
}