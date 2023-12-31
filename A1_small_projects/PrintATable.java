import java.lang.Math;

/**
 * 
 * Write a program that displays the following table.
 * 
 * a   b   pow(a, b)
 * 1   2   1
 * 2   3   8
 * 3   4   81
 * 4   5   1024
 * 5   6   15625
 * 
 * Instructions:
 * 1) The numbers in the third row MUST be computed using the Java Math.pow function. 
 *    (See https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#pow-double-double-) for documentation.
 * 2) Note that the Math.pow function returns a double value. For this problem, cast all floating-point numbers into integers.
 * 3) Mind the gap (three spaces) between each column -- they have to be there in your output.
 */
 public class PrintATable {
    
    public static void main(String[] args) {
        
        // Print the table header
        System.out.println("a   b   pow(a, b)");

        // Loop through the values of a from 1 to 5
        for (int a = 1; a <= 5; a++) {
            // calculate the result using math.pow
            int result = (int) Math.pow(a, a + 1);
            
            // print the values of a, b, and the result
            System.out.printf("%d   %d   %d%n", a, a + 1, result);
        }

    }
}