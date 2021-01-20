import java.util.Scanner;
import java.util.Arrays;

public class Task3{
    static int numAsTextToDigits(String[] a){
        String[] arrayText = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        String[] hundredsArrayText = {"one","two","three","four","five","six","seven","eight","nine"};
        int[] arrayDigit = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90};
        int[] hundredsArrayDigit = {100,200,300,400,500,600,700,800,900};
        
        int sum = 0;
        int size = a.length;
        int hundredIndex = 0;
        for(int i = 0; i < size; i++){
            if(a[i].equals("hundred") || a[i].equals("hundreds")){
                hundredIndex = i;
            }
        }
        if(hundredIndex > 0){
            for(int p = 0; p < hundredsArrayDigit.length; p++){
                if(a[hundredIndex-1].equals(hundredsArrayText[p])){
                    sum = sum + hundredsArrayDigit[p];
                }
            }
        }
        for(int j = hundredIndex; j < size; j++){
            for(int k = 0; k < arrayText.length; k++){
                if(a[j].equals(arrayText[k])){
                    sum = sum + arrayDigit[k];
                }
            }
        }
        
        return sum;
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String num;
        System.out.println("Enter a number as a text: ");
        num = scan.nextLine();
        String[] numSplit = num.split(" ");
        int size = numSplit.length;
    
        System.out.println(numAsTextToDigits(numSplit));
    }
}
