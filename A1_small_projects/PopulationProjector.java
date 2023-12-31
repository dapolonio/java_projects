import java.util.Scanner;

/**
 * This question is based on Question 1-11 in Liang's Intro to Java textbook.
 * 
 * Complete this program such that it:
 *  - calculates and displays the projected population for each of the next five years.
 *
 * The U.S. Census Bureau projects population based on the following assumptions:
 *  - Current population: 332,403,650
 *  - Each year has 365 days
 *  - One birth every 7 seconds
 *  - One death every 13 seconds
 *  - One new immigrant every 45 seconds
 * 
 * IMPORTANT:
 *  - There are no fractional people.  All population projections MUST be integers.
 *  - In Java, if two integers perform division, the result is an integer - the fractional part is truncated.  
 *    For example, 5/4 is 1 in Java (not 1.25). To get an accurate result with the fractional part, one
 *    of the values involved in the division must be a number with a decimal point. For example, 5.0/4 is 1.25 in Java.
 *     

 * PRESENTING YOUR OUTPUT:
 *  Your program should start with the following header (without the quotes): 
 * "Here are the projected population numbers for the next five years:"
 *  
 * Your program should then print the population for each year on separate lines. Something like:
 *  - Year 2024: [...] \\ Projected population in 2024
 *  - Year 2025: [...] \\ Projected population in 2025
 *  - Year 2026: [...] \\ Projected population in 2026
 *  - Year 2027: [...] \\ Projected population in 2027
 *  - Year 2028: [...] \\ Projected population in 2028
 * 
 * where you should substitute [...] for your calculated project population of the corresponding year.
 */

public class PopulationProjector {

    /**
     * The main function is automatically called first in a Java program.
     * Complete the assignment within this function.
     * 
     * @param args An array of any command-line arguments.  Java requires the main function include this, even if not used.
     * @throws Exception Allows us to not worry about Exceptions in this function. Java requires the main functino include this, even if not used.
     */
    public static void main(String[] args) throws Exception {
        // constants
        long currentPopulation = 332_403_650L; 
        int daysPerYear = 365;
        int secondsPerMinute = 60; 

    
        int birthsPerSecond = 1; 
        int deathsPerSecond = 1; 
        int immigrantsPerSecond = 1; //

     
        long populationChangePerYear = 
            //amount of pepople born per year
            birthsPerSecond * secondsPerMinute * daysPerYear / 7
            // amount of deaths per year
            - deathsPerSecond * secondsPerMinute * daysPerYear / 13 
            
            //amount of immigrants per year
            + immigrantsPerSecond * secondsPerMinute * daysPerYear / 45;

      
        System.out.println("Here are the projected population numbers for the next five years:");

        // calculate and display the projected population for the next 5 years, each year
        for (int year = 1; year <= 5; year++) {
            currentPopulation += populationChangePerYear;
            System.out.println("Year 202" + (4 + year) + ": " + currentPopulation);
        }
    }


}