import java.util.Scanner;

/**
 * Complete this program such that it:
 *  - asks the user how many kilometers they have run,
 *  - asks the user how many minutes it took them to run that distance,
 *  - displays the average speed of the runner in miles per hour.
 * 
 * Below is a sample of what the program should output when run, with example user responses.
 * The formatting of the questions and responses should be similar to the sample output, except for the numerical values (5, 30 and 6.2137), 
 * which will depend on the user's input.
 *
 *  How many kilometers did you run?
 *  5
 *  How many minutes did it take you?
 *  30
 *  Your average speed was 6.2137 miles per hour.
 */
public class RunningSpeedCalculator {

  /**
   * The main function is automatically called first in a Java program.
   * Write your program logic within this function.
  
   * Use the Scanner class's nextLine() function to get user input as a String
   * Use the Double.parseDouble() function to covert a String to a double.
   * Assume 1 mile = 1.609344 kilometers.
   * 
   * Do NOT round any numbers or limit any decimal places in your calculations.
   * Do, however, print the average speed to at most four decimal places. To do this, you may either 
   *    1) define a new variable that stores the average speed limited to four decimal places and output it, or 
   *    2) parse directly your average speed to four decimal places in your output, without changing the value of the average speed.
   * What matters is that the variable containing the average speed is never limited to any decimal places.
   * 
   * @param args An array of any command-line arguments.  Java requires the main function include this, even if not used.
   * @throws Exception Allows us to not worry about Exceptions in this function. Java requires the main functino include this, even if not used.
   */
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("How many kilometers did you run?");
    double kilometers = Double.parseDouble(scanner.nextLine());

    System.out.println("How many minutes did it take you?");
    double minutes = Double.parseDouble(scanner.nextLine());

    // calculate speed
    double miles = kilometers / 1.609344;
    double hours = minutes / 60;
    double speed = miles / hours;

    // display average speed to four decimal places
    System.out.printf("Your average speed was %.4f miles23 per hour.%n", speed);


    scanner.close();
  }


}