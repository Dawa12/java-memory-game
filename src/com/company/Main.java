package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println("Welcome to the Typing Challenge!");
        System.out.println("Enter your name!");
        System.out.println("----------------------------");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int n = reader.nextInt(); // Scans the next token of the input as an int.
//once finished
        reader.close();
        System.out.println("You entered " + n);
    }
}
