import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class randomizer {
	static int getRandomNumberInRange(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}
	
	static boolean check (int[] notRepeat, int rand) {
		boolean test = false;
		for(int i = 0; i < notRepeat.length; i++) {
			if(notRepeat[i] == rand) {
				test = true;
				break;
			}
		}
		return test;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String c = null;
		int min;
		int max;
	
		do {
			System.out.println("Enter a minimal value of a range (inclusive): ");
			min = scan.nextInt();
			
		} while(min < 1 || min > 501);
		
		do {
			System.out.println("Enter a maximal value of a range (exclusive): ");
			max = scan.nextInt();
		} while(max < min || max > 501);
		
		scan.nextLine();
		
		int[] notRepeat = new int[max-min];
		int rand;
		int count = 0;
		String h = null;
		
		do {
			System.out.println("Please, enter a command: generate/exit/help");
			//scan.nextLine();
			c = scan.nextLine();
				
			if(c.equals("help")) {
				
				System.out.println("Randomizer is a program which generate \n unique random numbers greater than \nor equal 1 and less then or equal 500. \nTo start you need enter minimal and maximal value \nof a range and enter the command _generate_. \nIf you want to stop, please anter command _exit_.\nGood luck!");
			}
			if(c.equals("generate")) {
				do {
					rand = getRandomNumberInRange(min, max);
				} while(check(notRepeat,rand));
				notRepeat[count] = rand;
				count++;
				System.out.println(rand);
				if(count >= notRepeat.length) {
					System.out.println("There are no more unique integers in a set range");
					break;
				}
			}
			
			if(c.equals("exit")) {
				System.out.println("Are you sure that you want to quit the app? (yes/no)");
				c = scan.nextLine();
			}
			
		} while (!c.equals("yes"));
	System.exit(0);
	}
}


