import java.util.Scanner;

public class Task3ConditionalOperators {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number a");
        int a = scan.nextInt();
        System.out.println("Enter the number b");
        int b = scan.nextInt();
        System.out.println("Enter the number c");
        int c = scan.nextInt();
        int d = 0; 
        
        if(a > 0){
            d = d + a; 
        }
        if(b > 0){
            d = d + b;
        }
        if(c > 0){
            d = d + c;
        }
        
        System.out.println ("The sum of the positive integers is " + d);
    }
}