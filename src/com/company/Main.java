package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println("Welcome to the Typing Challenge!");
        System.out.println("Enter your name!");
        System.out.println("----------------------------");

//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter your Name: ");
//        String n = reader.nextLine(); // Scans the next token of the input as an String.
////once finished
//        System.out.println("Welcome " + n + "!");

        String randomString = getRandomString();
        System.out.println("Type along!");
        System.out.println(randomString);

        Scanner reader = new Scanner(System.in);
        String n = reader.nextLine();

        calculateScore(randomString, n);
        reader.close();
    }

    public static String getRandomString() {
//        String pattern = "(.*)(\\d+)(.*)";
        String randomString = new String("abcdefg");
        return randomString;
    }

    public static String calculateScore(String randomString,String userInput) {
        int score = 0;
//    increment score for every character that matches userInput
        for (int i = 0; i < randomString.length(); i++) {
            try {
                userInput.charAt( i );
            } catch (Exception e){
//                try to catch OutofBoundsException
                System.out.println(e);
                break;
            }

            if(randomString.charAt( i ) == userInput.charAt( i
            )) {
               score++;
            }
//            System.out.println(userInput.charAt(i));
        }
        System.out.println("Score: " + score);
        return "h";
    }
}
