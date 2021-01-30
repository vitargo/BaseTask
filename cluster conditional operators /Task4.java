import java.util.Scanner;

public class Task4{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number a");
        int a = scan.nextInt();
        System.out.println("Enter the number b");
        int b = scan.nextInt();
        System.out.println("Enter the number c");
        int c = scan.nextInt();
        
        int d = a * b * c;
        int e = a + b + c;
        int f = Math.max(d, e);
        
        System.out.println(f + 3);  
    }
}