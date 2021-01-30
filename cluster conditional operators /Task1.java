import java.util.Scanner;

public class Task1{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number a");
        int a = scan.nextInt();
        System.out.println("Enter the number b");
        int b = scan.nextInt();
        int c;
        
        if(a % 2 == 0){
            c = a * b;
            System.out.println("a * b = " + c);
        } else {
            c = a + b;
            System.out.println("a + b = " + c);
        }
    }
}