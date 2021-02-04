package com.github.randomizer;

public class CommandDialog {
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

    public static void commandDialog(int[] notRepeat, int max, int min){
        String c = null;
        int rand;
        int count = 0;

        do {
            System.out.println("Please, enter a command: generate/exit/help");
            c = ScannerWrapper.getCommand();

            if(c.equals("help")) {
                System.out.println("Randomizer is a program which generate \n unique random numbers greater than \nor equal 1 and less then or equal 500. \nTo start you need enter minimal and maximal value \nof a range and enter the command _generate_. \nIf you want to stop, please anter command _exit_.\nGood luck!");
            }
            if(c.equals("generate")) {
                do {
                    rand = RandomNumber.getRandomNumberInRange(min, max);
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
                c = ScannerWrapper.getCommand();
            }

        } while (!c.equals("yes"));
        System.exit(0);
    }

}
