import java.util.Scanner;

/**
 * 
 * Complete this program such that it:
 *  - Prompts the user to enter an amount the user adds to their savings account each month.
 *      - Assume that this amount is the same each month.
 *      - Use the Scanner class's nextLine() function to get user input as a String.
 *      - Assume the user will enter a valid number with or without a decimal place... don't worry about handling any other type of user input.
 * 
 *  - Displays the savings account value, in today's dollars, after the sixth month.
 *      - Assume an annual interest rate of of 5%.
 *      - The monthly interest is thus 0.05/12 - 0.00417.   
 *      - Limit the output to three decimal values.
 *
 *  Note: You can use loops for this problem if you already know how to.
 * 
 * Sample output, including example user input. Your program should format the output similarly to this: 
 *  Please enter your monthly savings rate: 120
 *  If you save $120 per month with 5% annual interest rate, after 6 months, your account will contain $730.573.
 */

public class CompoundValue {
    
    public static void main(String[] args) {
        // scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your monthly savings rate: ");
        String input = scanner.nextLine();
        double monthlySavings = Double.parseDouble(input);
        scanner.close();
        
        // annual interest rate 5%, after 6 months
        double annualInterestRate = 0.05;
        int numberOfMonths = 6;
        
        double monthlyInterestRate = annualInterestRate / 12.0;
        
        double futureValue = 0;
        for (int i = 0; i < numberOfMonths; i++) {
            futureValue += monthlySavings;
            futureValue *= (1 + monthlyInterestRate);
        }
        
        System.out.printf("If you save $%.2f per month with 5%% annual interest rate, after %d months, your account will contain $%.3f.%n",
                          monthlySavings, numberOfMonths, futureValue);
    }
}
