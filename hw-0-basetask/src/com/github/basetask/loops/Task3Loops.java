import java.util.Scanner;

public class Task3Loops {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int number;
        
        do {
            System.out.print("Enter a valid number: ");
            number = scan.nextInt();
        } while(number < 0);
        
        if(number == 0 || number == 1){
            System.out.println ("Cube root to the nearest whole number is " + number);
            return;
        }
        
        int a = 1;
        int b = number/2;
        while(a <= b){
            int c = a + (b - a)/2;
            if (c == number/c){
                System.out.println ("Cube root to the nearest whole number is " + c);
                return;
            }
            if(c < number/c){
                a = c + 1;
            } else {
                b = c - 1;
            }
        }
        System.out.println ("Cube root to the nearest whole number is " + (a-1));
    }
}