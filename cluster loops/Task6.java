import java.util.Scanner;

public class Task6{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        
        boolean sign = true;
        
        if(number < 0){
            sign = false;
            number = Math.abs(number);
        }
        
        int ref = 0;
        
        while(number > 0){
            int i = number%10;
            ref = (ref * 10) + i;
            number = number/10;
            
            if(number == 0){
                break;
            }
        }
        if(!sign){
            ref = ref * -1;
        }
        System.out.println ("Reflection number is " + ref);
    }
}