import java.util.Scanner;
import java.lang.Math;

public class Task4{
    static double distanceBetweenPoints(double x1, double y1, double x2, double y2){
        double sqrHypo = (x1 - x2) * (x1 - x2) + (y1 -y2) * (y1 -y2);
        return Math.sqrt(sqrHypo);
        
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter x1: ");
        double x1 = scan.nextDouble();
        System.out.println("Enter y1: ");
        double y1 = scan.nextDouble();
        System.out.println("Enter x2: ");
        double x2 = scan.nextDouble();
        System.out.println("Enter y2: ");
        double y2 = scan.nextDouble();
        
        System.out.println(distanceBetweenPoints(x1,y1,x2,y2));
    }
}