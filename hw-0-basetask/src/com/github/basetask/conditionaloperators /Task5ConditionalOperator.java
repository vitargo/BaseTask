import java.util.Scanner;

public class Task5ConditionalOperator {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the student's score:");
        int score = scan.nextInt();
    
        if(score > -1 && score < 20){
            System.out.println ("Student’s result is F");
        } else if(score > 19 && score < 40){
            System.out.println ("Student’s result is E");
        } else if(score > 39 && score < 60){
            System.out.println ("Student’s result is D");
        } else if(score > 59 && score < 75){
            System.out.println ("Student’s result is C");
        } else if(score > 74 && score < 90){
            System.out.println ("Student’s result is B");
        } else if(score > 89 && score < 101){
            System.out.println ("Student’s result is A");
        } else {
            System.out.println ("Unacceptable student’s score"); 
        }
    }
}