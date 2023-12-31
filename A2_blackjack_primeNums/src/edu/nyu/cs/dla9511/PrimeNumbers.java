package edu.nyu.cs.dla9511;
import java.util.Scanner;

/**
 * Q2: Prime numbers (10 pts)
 * 
 * Write a Java program that prints out all prime numbers between 
 * two integer inputs `a` and `b` (without the quotes), inclusive.
 * 
 * In addition, replace NetID in edu.nyu.cs.NetID on the first line with your own NetID,
 * and rename the folder containing this piece of code with your NetID.
 * 
 * 
 * Notes:
 *    This problem asks you to write a complex program, which may be difficult for novice programmers.
 * 
 *    Don't panic! 
 * 
 *    The key to developing a programmatic solution for this problem, and for
 *    many other problems, is to break it into subproblems and develop solutions 
 *    for each of them in turn.
 * 
 *    In particular, do not attempt to develop a complete solution in the first trial. 
 * 
 *    I suggest breaking down this problem into three components:
 *      i)    Prompting the user for input and checking if the input is correct (see instructions).
 *      ii)   Checking whether a given positive integer is prime.
 *      iii)  Expand the program to test whether other numbers are prime in a loop.
 * 
 *    If you can complete steps i)-iii), then you should be in a good position to complete this problem!
 * 
 * 
 * Instructions:
 * 1) The inputs a and b (defined in the main method for your convenience) should be provided by the user.
 * 
 *    You may use any methods from the Scanner class to help you do so. 
 * 
 *    The inputs a and b should be i) integers, ii) strictly positive (>= 1) and iii) the input b should be greater or equal than a. 
 *      - You may assume the input will always be entered as integers. You do NOT need to check this.
 *      - However, you MUST check whether the inputs are strictly positive and whether b >= a.
 *        If the inputs are incorrect, your program should print "Incorrect input!" and stop. 
 * 
 * 
 * 2) An integer greater than 1 is prime if its only positive divisor is 1 or itself.
 *    For example, the numbers 2,3,5,7 are all prime numbers, but 4,6,8, and 9 are not.
 * 
 *    To determine whether a number is prime, check whether it is divisible by a number between 2 and number/2.
 * 
 * 
 * 3) Your code should print out all prime numbers between the integer inputs a and b, inclusive.
 *    The formatting of the output is not important; you'll get full marks as long as the input is checked
 *    for correctness and all the correct prime numbers are printed,
 */

public class PrimeNumbers {
    /**
     * The main function is automatically called first in a Java program.
     *
     * @param args An array of any command-line arguments.
     */
    public static void main(String[] args) throws Exception {
        int a, b;   // Use these variables as inputs.

        //get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting integer 'a': ");
        a = scanner.nextInt();
        System.out.print("Enter the ending integer 'b': ");
        b = scanner.nextInt();

        // validate the user input. if numbers don't meet criteria, ask for input again
        if (a < 1 || b < 1 || b < a) {
            System.out.println("Incorrect input!");
            return;
        }

        // loop through numbers between 'a' and 'b' and print prime numbers
        for (int num = a; num <= b; num++) {
            //if the method isPrime returns true, it is a prime number, and system will print it out
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
   
        scanner.close();
    }

    // to check whether a positive integer is prime   
    public static boolean isPrime(int num) {
        //the following are easy cases to start of verifying
        // prime numbers have to be greater than 1
        if (num <= 1) {
            return false;
        }
        // if the integer is 2 or 3, it is prime
        if (num <= 3) {
            return true;
        }
        // if the integer is divisible by 2 or 3, it is not prime
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        // to check further numbers, start at 3 and increment by 2 (to check odd numbers, since
        // even numbers automatically cannot be prime numbers)
        for (int i = 3; i * i <= num; i += 2) {
          if (num % i == 0) {
              // if num is divisible by any divider, it's not prime, and the method returns false
              return false;
          }
        }
        return true;
    }
}

