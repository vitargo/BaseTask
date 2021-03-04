import java.util.Scanner;

public class Task2Loops {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        int number;
        
        do {
            System.out.print("Enter a number: ");
            number = scan.nextInt();
        } while(number < 1);
        
        if(number == 1){
            System.out.println ("Number isn't a simple.");
            return;
        }
        
        boolean m = false;
        
        for (int i = 2; i < number; i++){
            if (number % i == 0) {
                m = true;
                break;
            }
        }
        if(m){
            System.out.println ("Number isn't a simple.");
        } else {
            System.out.println ("Number is a simple.");
        }
    }
}