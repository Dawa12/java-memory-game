package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("----------------------------");
        System.out.println("Welcome to the Typing Challenge!");
        System.out.println("Enter your name!");
        System.out.println("----------------------------");
        
//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter your Name: ");
//        String n = reader.nextLine(); // Scans the next token of the input as an String.
////once finished
//        System.out.println("Welcome " + n + "!");

        while(true) {
            String randomString = getRandomString();
            System.out.println("Type along!");
            System.out.println(randomString);

            calculateScore(randomString);
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

    public static void calculateScore(String randomString) {
        int score = 0;
        Scanner reader = new Scanner(System.in);

        System.out.println("5 seconds to answer!");
        long start = System.currentTimeMillis();
//        end program in 5 seconds
        long end = start + 1*1000; // 60 seconds * 1000 ms/sec
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
                            " Final Score: " + score +
                            " --------------";

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(finalScore);

        // ANSI escape code to update console text color;
//        System.out.println(("\033[31m Hello\033[0m" + " hiiiiii"));
    }
}
