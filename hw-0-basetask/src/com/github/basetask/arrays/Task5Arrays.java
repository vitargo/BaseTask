import java.util.Scanner;

public class Task5Arrays {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int sumOddIndex = 0;
        for(int i = 0; i < size; i++){
            if(i % 2 != 0){
                sumOddIndex = sumOddIndex + array[i];
            }
        }
    System.out.println("A sum of odd-index array elements is " + sumOddIndex);
    }
}