import java.util.Scanner;

public class Task5{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        
        number = Math.abs(number);
        
        int sum = 0;
        while(number > 0){
            int i = number%10;
            sum = sum + i;
            number = number/10;
            
            if(number == 0){
                break;
            }
        }
        System.out.println("Sum of the number's digits is " + sum);
    }
}