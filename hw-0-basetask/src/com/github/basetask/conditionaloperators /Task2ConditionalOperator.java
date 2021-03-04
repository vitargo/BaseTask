import java.util.Scanner;

public class Task2ConditionalOperator {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the coordinate x (int):");
        int x = scan.nextInt();
        System.out.println("Enter the coordinate y (int):");
        int y = scan.nextInt();
        
        if(x > 0 && y > 0){
            System.out.println ("I Quadrant");
        } else if(x < 0 && y > 0){
            System.out.println ("II Quadrant");
        } else if(x < 0 && y < 0){
            System.out.println ("III Quadrant");
        } else if(x > 0 && y < 0){
            System.out.println ("IV Quadrant");
        } else if(x == 0 && y == 0){
            System.out.println ("Origin");
        } else {
            System.out.println ("Point lies on the axis");
        }
    }
}