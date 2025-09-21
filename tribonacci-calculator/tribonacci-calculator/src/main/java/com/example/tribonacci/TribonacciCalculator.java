package main.java.com.example.tribonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TribonacciCalculator {

    //main logic for calculating a single tribonacci number
    public static long tribonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Position can't be negative, sorry!");
        }
        
        // this will handle the first few numbers separately
        if (n == 0) return 0L;
        if (n == 1 || n == 2) return 1L;
        long a = 0L, b = 1L, c = 1L;
        long nextValue = 0L;

        for (int i = 3; i <= n; i++) {
            nextValue = a + b + c;
            a = b;
            b = c;
            c = nextValue;
        }
        return nextValue;
    }

    //this method helps to generate a whole list of them
    public static List<Long> generateSequence(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must be positive. Seriously, why would you want a negative number of items?");
        }
        
        List<Long> sequence = new ArrayList<>();
        // loop to call the main function.
        for (int i = 0; i < count; i++) {
            sequence.add(tribonacci(i));
        }
        return sequence;
    }

    //user interaction part
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Let's talk Tribonacci.");
        
        // will loop until the user says "bye".
        while (true) {
            System.out.println("\nWhat's next? (1) Get a single number | (2) Generate a bunch | (3) Exit");
            System.out.print(">> ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("3") || choice.equalsIgnoreCase("exit") || choice.equalsIgnoreCase("quit")) {
                System.out.println("Cool. See you around!");
                break;
            }

            try {
                if (choice.equals("1")) {
                    System.out.print("Enter a non-negative number: ");
                    String line = scanner.nextLine().trim();
                    int n = Integer.parseInt(line);
                    
                    // TODO: The `long` type can still overflow for very large n. Need to handle this properly later
                    if (n > 50) {
                        System.out.println("Warning: numbers over 50 might be unreliable. The result could be too big!");
                    }
                    long value = tribonacci(n);
                    System.out.println("Result: f(" + n + ") is " + value);
                } else if (choice.equals("2")) {
                    System.out.print("How many numbers do you want? ");
                    int count = Integer.parseInt(scanner.nextLine().trim());
                    List<Long> seq = generateSequence(count);
                    
                    System.out.println("The tribonacci sequence:");
                    for (int i = 0; i < seq.size(); i++) {
                        System.out.println("f(" + i + ") = " + seq.get(i));
                    }
                } else {
                    System.out.println("I didn't get that. Try 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a number. Try again with digits!");
            } catch (IllegalArgumentException e) {
                System.out.println("Whoa, invalid input: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Something unexpected went wrong. Sorry about that!");
            }
        }
        scanner.close();
    }
}
