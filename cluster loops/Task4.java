import java.util.Scanner;

public class Task4{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        
        long f = 1;
        
        for(int i = 1; i <= number; i++){
            f = f * i;
        }
        System.out.println("Factorial of a number is " + f);
    }
}