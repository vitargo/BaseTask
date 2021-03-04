import java.util.Scanner;
import java.util.Arrays;

public class Task6Methods {
    static Long numAsTextToDigits(String[] a){
        String[] arrayText = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        String[] hundredsArrayText = {"one","two","three","four","five","six","seven","eight","nine"};
        int[] arrayDigit = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90};
        int[] hundredsArrayDigit = {100,200,300,400,500,600,700,800,900};
        
        long sum = 0;
        int size = a.length;
        int count = 0;
        for (int y = 0; y < size; y++ ){
            if(a[y] == null){
                count++;
            }
        }
        if(count == size){
            return sum;
        }
        
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
        for(int z = 0; z < size; z++){
            if(a[z].equals("billion") || a[z].equals("billions")){
                sum = sum * 1000000000;
            }
            if(a[z].equals("million") || a[z].equals("millions")){
                sum = sum * 1000000;
            }
            if(a[z].equals("thousand") || a[z].equals("thousands")){
                sum = sum * 1000;
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
        String[] numBillions = new String[size];
        String[] numMillions = new String[size];
        String[] numThousands = new String[size];
        String[] numHundreds = new String[size];
        int b = 0;
        int m = 0;
        int t = 0;
        for(int i = 0; i < size; i++){
            if(numSplit[i].equals("billions") || numSplit[i].equals("billion")){
                b = i;
            } else if(numSplit[i].equals("millions") || numSplit[i].equals("million")){
                m = i;
            } else if(numSplit[i].equals("thousands") || numSplit[i].equals("thousand")){
                t = i;
            }
        }
        int startMil = b+1;
        int startThous = m+1;
        int startHund = t+1;
        if(b == 0){
            startMil = 0;
        } 
        if(m == 0){
            if(b == 0){
                startThous = 0;
            } else {
                startThous = b+1;
            }
        }
        if(t == 0){
            if(m == 0 && b == 0){
                startHund = 0;
            } else if(m == 0){
                startHund = b+1;
            } else {
            startHund = m+1; 
            }
        }
        if(b != 0){
            numBillions = Arrays.copyOfRange(numSplit, 0, b+1);
        }
        if(m != 0){
            numMillions = Arrays.copyOfRange(numSplit, startMil, m+1);
        }
        if(t != 0){
            numThousands = Arrays.copyOfRange(numSplit, startThous, t+1);
        }
            numHundreds = Arrays.copyOfRange(numSplit, startHund, size);
    
        System.out.println(numAsTextToDigits(numBillions) + numAsTextToDigits(numMillions) + numAsTextToDigits(numThousands) + numAsTextToDigits(numHundreds));
    }
}
