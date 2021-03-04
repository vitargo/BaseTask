import java.util.Scanner;
import java.lang.Math;

public class Task4v2Methods {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter x1: ");
        double x1 = scan.nextDouble();
        System.out.println("Enter y1: ");
        double y1 = scan.nextDouble();
        System.out.println("Enter x2: ");
        double x2 = scan.nextDouble();
        System.out.println("Enter y2: ");
        double y2 = scan.nextDouble();
        
        System.out.println(Math.hypot((x1-x2), (y1-y2)));
    }
}