import java.util.Scanner;
import java.util.Arrays;
public class Task10MergeSort{
    private static void merge_Sort(int[] array){ 
        if(array == null){ 
            return; 
        } 
          if(array.length > 1){ 
            int mid = array.length/2;
            int[] left = new int[mid]; 
            for(int i = 0; i < mid; i++){ 
                left[i] = array[i]; 
            } 
            int[] right = new int[array.length - mid]; 
            for(int i = mid; i < array.length; i++){ 
                right[i-mid] = array[i]; 
            } 
            merge_Sort(left); 
            merge_Sort(right);
            int i = 0; 
            int j = 0; 
            int k = 0; 
            while(i < left.length && j < right.length){ 
                if(left[i] < right[j]){ 
                    array[k] = left[i]; 
                    i++; 
                } 
                else { 
                    array[k] = right[j]; 
                    j++; 
                } 
                k++; 
            } 
            while(i < left.length){ 
                array[k] = left[i]; 
                i++; 
                k++; 
            } 
            while(j < right.length){ 
                array[k] = right[j]; 
                j++; 
                k++; 
            } 
        } 
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements: ");
        for(int i = 0; i < size; i++){
            array[i] = scan.nextInt();
        }
        int i = 0;
        merge_Sort(array); 
        System.out.println("An array sorted with Merge Sort: " + Arrays.toString(array));
    }
}