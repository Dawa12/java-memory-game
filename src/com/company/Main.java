package com.company;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Main {
    static Hashtable<Integer,Integer> scoreHistory = new Hashtable<Integer, Integer>();

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

        while(true) {
             //        player enters "play" or "history"
                     while(true) {
                         System.out.println("1. Type 'play' to play " +
                                             " 2. Type 'history' to view your game history");

//                         Scanner reader = new Scanner(System.in);  // Reading from System.in
                         String startInput = reader.nextLine();

                         if (startInput.equals("history")) {
                             showHistory();
                         } else if (startInput.equals("play")) {
             //                exit loop only if player enters "play"
                             System.out.println("you entered: " + startInput);
                             break;
                         } else {
                             System.out.println("Invalid input");
                         }
                     }

            printRules();

            System.out.println();
            System.out.println("Press enter to begin!");

//            waiting for any user keypress
            reader.nextLine();

            // clear the console
            for (int k = 0; k < 50; k++) {
                System.out.println();
            }

            System.out.println("Don't type! Memorize this string for five seconds");

//            String randomString = getRandomString();
            String randomString = shuffle("abcdefghijklmnop");

            System.out.println(randomString);

            long start = System.currentTimeMillis();
    //        end program in 5 seconds
            long end = start + 5*1000; // 60 seconds * 1000 ms/sec

            int i = 0;
            while (System.currentTimeMillis() < end) {
//                System.out.println(i);
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
        String randomString = new String("caqqwdcaw");
        return randomString;
    }

    public static void showHistory() {
        int size = scoreHistory.size();

        if(size > 0) {
            System.out.println( "showing history" );

            Set<Integer> keys = scoreHistory.keySet();

            //Obtaining iterator over set entries
            Iterator<Integer> itr = keys.iterator();

            //Displaying Key and value pairs
            while (itr.hasNext()) {
                // Getting Key

                int str = itr.next();

                System.out.println( "Game: " + str + ": Final Score: " + scoreHistory.get( str ) );
            }
        } else {
            System.out.println("No history of games yet!");
        }
    }


//    randomize string shuffle method copied from: https://stackoverflow.com/a/3316696/4544892
    public static String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
//        System.out.println(output.toString());
        return output.toString();
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

            //    increment score for every character that matches userInput
            for (int i = 0; i < randomString.length(); i++) {
                char n;
                try {
                    n = reader.findInLine(".").charAt(0);
                } catch (Exception e){
//                    not logging exception since it will interrupt console game
                    break;
                }

//                after countdown timer expires, and you read user input
//                System.out.println("time's up!");

//                character matching and scoring logic
                if(randomString.charAt( i ) == n) {
                    score++;
                    System.out.println(randomString.charAt( i ) + " is " + "correct! New Score: " + score);
                } else {
                    System.out.println(randomString.charAt( i ) + " is " + "Wrong! score remains: " + score);
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

            int size = scoreHistory.size();

            if(size > 0) {
                scoreHistory.put(size + 1, score);
            } else {
                scoreHistory.put(1, score);
            }
    }
}
