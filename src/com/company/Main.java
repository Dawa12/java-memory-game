package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        printGreeting();
        
//        capture user name
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String name = reader.nextLine(); // Scans the next token of the input as an String.
//once finished
        Player player1 = new Player( name );

        System.out.println();
        System.out.println("Welcome " + player1.getName() + "!");
        System.out.println();

        printRules();

        while(true) {
            System.out.println();
            System.out.println("Press enter to begin!");

//            waiting for any user keypress
            reader.nextLine();

//              clear the console
            for (int k = 0; k < 50; k++) {
                System.out.println();
            }

            System.out.println("Don't type! Memorize this string for five seconds");

            String randomString = getRandomString();
            System.out.println(randomString);

    //        System.out.println("5 seconds to answer!");
            long start = System.currentTimeMillis();
    //        end program in 5 seconds
            long end = start + 5*1000; // 60 seconds * 1000 ms/sec

            int i = 0;
            while (System.currentTimeMillis() < end) {
//                System.out.println( "counting seconds" + System.currentTimeMillis());
//                System.out.println("counting " + i);
//                i++;
            }

//            clear the console
            for (int j = 0; j < 50; j++) {
                System.out.println();
            }

            System.out.println("time's up!");
            System.out.println("give your best guess!");

            calculateScore( randomString, player1 );

            char response = playAgain();

//            if player types 'n' then break out of game loop
            if(response == 'n') {
                return;
            }
        }
    }

    public static String getRandomString() {
//        String pattern = "(.*)(\\d+)(.*)";
        String randomString = new String("abcdefg");
        return randomString;
    }

    public static void printGreeting() {
         System.out.println("----------------------------");
         System.out.println("Welcome to the Memory Challenge!");

         System.out.println("Enter your name!");
         System.out.println("----------------------------");
    }

    public static void printRules() {
        //            print game rules
        System.out.println("-------------Rules-------------");
        System.out.println("You have five seconds to remember the characters below!");
        System.out.println("Wait until the prompt tells you to type!");
    }

    public static char playAgain() {
        System.out.println("Play again? (y/n)");
        Scanner reader = new Scanner(System.in);

//        find first character of player input and lowercase it
        char input = reader.findInLine(".").charAt(0);
        String stringInput = String.valueOf(input).toLowerCase();

//          check for valid user input
        if(stringInput.contains( "y" )) {
            System.out.println( "playing again!" );
            return 'y';
        } else if (stringInput.contains( "n" )) {
            System.out.println( "not playing again :(" );
//            close System reader when game finishes
            reader.close();
            return 'n';
        } else {
            System.out.println("please enter y/n");
        }

        return 'n';
    }

    public static void calculateScore(String randomString, Player player) {
        int score = 0;
        Scanner reader = new Scanner(System.in);
        
//
////        System.out.println("5 seconds to answer!");
//        long start = System.currentTimeMillis();
////        end program in 5 seconds
//        long end = start + 1*1000; // 60 seconds * 1000 ms/sec
//
//        while (System.currentTimeMillis() < end) {
//            System.out.printf( "counting seconds" + System.currentTimeMillis());
//        }


//        while (System.currentTimeMillis() < end)
//        {
            //    increment score for every character that matches userInput
            for (int i = 0; i < randomString.length(); i++) {
                char n;
                try {
                    n = reader.findInLine(".").charAt(0);
                } catch (Exception e){
//                try to catch OutofBoundsException or NullPointerException if user types too little or too much
//                    System.out.println("catching exception ");
//                    System.out.println(e);
                    break;
                }

//                after countdown timer expires, and you read user input
//                System.out.println("time's up!");

//                character matching and scoring logic
                if(randomString.charAt( i ) == n) {
                    score++;
                    System.out.println("Correct! New Score: " + score);
                } else {
                    System.out.println("Wrong! score remains: " + score);
                }

//                closing while loop bracket
//            }
            }

           String finalScore = "--------------" +
                       " Final Score For " + player.getName() + ": " + score +
                       " --------------";

           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println(finalScore);

        // ANSI escape code to update console text color;
//        System.out.println(("\033[31m Hello\033[0m" + " hiiiiii"));
    }
}
