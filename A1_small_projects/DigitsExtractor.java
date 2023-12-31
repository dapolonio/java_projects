import java.util.Scanner;

/**
 * 
 * Write a program that reads an integer between 0 and 1000 and adds all the digits
 * in the integer. For example, if an integer is 932, the sum of all its digits is 14.
 * 
 * Note: You may assume that the user will enter the correct integer output.
 * 
 * Hint: Use the % operator to extract digits, and use the / operator to remove the extracted digit.
 * For instance,
 *      932 % 10 = 2
 *      932 / 10 = 93
 * 
 * Here is a sample run:
 * Enter a number between 0 and 1000: 999
 * The sum of the digits is 27.
 * 
 */

public class DigitsExtractor {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int number = scanner.nextInt();
        scanner.close();
        
        int sum = 0;
        while (number > 0) {
            // get the last digit since any number > 10 divded by 10 will isolated the num in the 'ones' place
            int digit = number % 10;
            
            // add the digit to the sum
            sum += digit;
            
            // divide the number by 10 to get rid of the remainder
            number /= 10;
        }
        
        // display the sum of the digits
        System.out.println("The sum of the digits is " + sum + ".");
    }
}
