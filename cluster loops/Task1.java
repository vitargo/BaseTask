public class Task1{
    public static void main(String args[]){
        int count = 0;
        int s = 0;
        
        for(int i = 1; i < 100; i ++){
            if(i % 2 == 0){
               s = s + i;
               count++;
            }
        }
        System.out.println ("Sum  of even numbers from 1 to 99 is " + s);
        System.out.println ("Number of even numbers from 1 to 99 is " + count);
    }
}