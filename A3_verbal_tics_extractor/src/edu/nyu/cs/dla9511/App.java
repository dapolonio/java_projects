package edu.nyu.cs.dla9511;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A program to analyze the use of verbal tics in any transcribed text.
 * Complete the functions to perform the tasks indicated in the comments.
 * Refer to the README.md file for additional requirements and helpful hints.
 */
public class App {

  // Use this "global" Scanner variable when getting keyboard input from the user within any function;
  // This avoids common problems using several different Scanners within different functions.
  // Do not use anything else for getting input!

  public static Scanner scn = new Scanner(System.in);

  /**
   * The main function is automatically called first in a Java program.
   * This function contains the main logic of the program that makes use of all the other functions to solve the problem.
   * This main function MUST use the other functions to perform the tasks those functions are designed for:
   * - you must use the getFilepathFromUser() to get the file path to the text file that the user wants to analyze
   * - you must use the getContentsOfFile() function whenever you need to get the contents of the text file
   * - you must use the getTicsFromUser() function whenever you need to get the set of tics the user wants to analyze in the text
   * - you must use the countOccurrences() function whenever you want to count the number of occurrences of a given tic within the text
   * - you must use the calculatePercentage() function whenever you want to calculate the percentage of all tics in the text that a given tic consumes
   * - you must use the calculateTicDensity() function to calculate the proportion of all words in the text that are tic words
   *
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    // get the file path from the user
    String filepath = getFilepathFromUser();
    // get the full text from the file
    String fullText = getContentsOfFile(filepath);
    // get the tics from the user
    String[] tics = getTicsFromUser();

    analyzeAndPrintResults(fullText, tics);
  }

  public static void analyzeAndPrintResults(String fullText, String[] tics) {
    System.out.println("...............................Analyzing text.................................\n");

    int totalTics = 0;
    int totalWords = fullText.split("[\\s\n\t.,?!]+").length;
    int[] ticsCount = new int[tics.length];

    for (int i = 0; i < tics.length; i++) {
      tics[i] = tics[i].trim(); // remove leading and trailing whitespace
    }

    for (int i = 0; i < tics.length; i++) {
      ticsCount[i] = countOccurrences(tics[i], fullText);
      totalTics += ticsCount[i];
    }

    double ticDensity = calculateTicDensity(totalTics, totalWords);

    System.out.println("Total number of tics: " + totalTics);
    System.out.println("Density of tics (proportion of all words in the text that are tics): " + String.format("%.2f", ticDensity));

    System.out.println("\n...............................Tic breakdown.................................");
    for (int i = 0; i < tics.length; i++) {
      int percentage = calculatePercentage(ticsCount[i], totalTics);
      System.out.printf("%-10s / %-20s / %d%% of all tics\n", tics[i], ticsCount[i] + " occurrences", percentage);
    }
  }

  /**
   * getFilepathFromUser method
   * Asks the user to enter the path to the text file they want to analyze.
   * Hint:
   * - use the "global" Scanner variable scn to get the response from the user, rather than creating a new Scanner variable within this function.
   * - do not close the "global" Scanner so that you can use it in other functions
   *
   * @return The file path that the user enters, e.g. "data/trump_speech_010621.txt"
   */
  public static String getFilepathFromUser() {
    System.out.print("What file would you like to open?\n> ");
    return scn.nextLine();
  }

  /**
   * getContentsOfFile method
   * Opens the specified file and returns the text therein.
   * If the file can't be opened, print out the message, "Oh no... can't find the file!"
   *
   * @param filepath The path to a text file containing a speech transcript with verbal tics in it.
   * @return The full text in the file as a String.
   */
  public static String getContentsOfFile(String filepath) {
    String fullText = "";
    boolean validFile = false;
    // keep asking the user for a text file if it is invalid 
      while (!validFile) {
        try {
        Scanner fileScanner = new Scanner(new File(filepath));
        while (fileScanner.hasNextLine()) {
          fullText += fileScanner.nextLine() + " ";
        }
        fileScanner.close();
        validFile = true;
      } catch (FileNotFoundException e) {
        System.out.println("Oh no... can't find the file!");
        filepath = getFilepathFromUser();
      }
    }
    
    return fullText;
  }

  /**
   * getTicsFromUser method
   * Asks the user to enter a comma-separated list of tics, e.g. "uh,like, um, you know,so", and returns an array containing those tics, e.g. { "uh", "like", "um", "you know", "so" }.
   * Hint:
   * - use the "global"-ish Scanner variable scn to get the response from the user, rather than creating a new Scanner variable within this function.
   * - do not close the "global"-ish Scanner so that you can use it in other functions
   *
   * @return A String array containing each of the tics to analyze, with any leading or trailing whitespace removed from each tic.
   */
  public static String[] getTicsFromUser() {
    System.out.print("What words would you like to search for?\n> ");
    String ticsInput = scn.nextLine();
    String[] tics = ticsInput.split(",");
    for (int i = 0; i < tics.length; i++) {
      tics[i] = tics[i].trim(); // remove any leading and trailing whitespace from each tic
    }
    return tics;
  }

  /**
   * countOccurrences method
   * Counts how many times a given string (the needle) occurs within another string (the haystack), ignoring case.
   *
   * @param needle   The String to search for.
   * @param haystack The String within which to search.
   * @return The number of occurrences of the "needle" String within the "haystack" String, ignoring case.
   */
  public static int countOccurrences(String needle, String haystack) {
    String regex = "(?i)\\b" + needle + "\\b"; // case insensitive whole word matching
    int count = 0;
    Scanner scanner = new Scanner(haystack);
    while (scanner.hasNext()) {
      if (scanner.next().matches(regex)) {
        count++;
      }
    }
    scanner.close();
    return count;
  }

  /**
   * calculatePercentage method
   * Calculates the equivalent percentage from the proportion of one number to another number.
   *
   * @param num1 The number to be converted to a percentage. i.e. the numerator in the ratio of num1 to num2.
   * @param num2 The overall number out of which the num1 number is taken. i.e. the denominator in the ratio of num1 to num2.
   * @return The percentage that num1 represents out of the total of num2, rounded to the nearest integer.
   */
  public static int calculatePercentage(int num1, int num2) {
    if (num2 == 0) {
      // not possible to determine percentage by dividing by 0 so return 0
      return 0;
    }
    double proportion = (double) num1 / num2;
    // convert to percentage and round to nearest integer
    return (int) Math.round(proportion * 100);
  }

  /**
   * calculateTicDensity method
   * Calculates the "density" of tics in the text. In other words, the proportion of tic words to the total number of words in a text.
   * Hint:
   * - assume that words in the text are separated from one another by any of the following characters: space ( ), line break (\n), tab (\t), period (.), comma (,), question mark (?), or exclamation mark (!)
   * - all Strings have a .split() method which can split by any of a collection of characters given as an argument; This function returns an array of the remaining text that was separated by any of those characters
   * - e.g. "foo-bar;baz.bum".split("[-;.]+") will result in an array with { "foo", "bar", "baz", and "bum" } as the values.
   *
   * @param totalTics The total number of tics found in the text.
   * @param totalWords The total number of words in the text.
   * @return The proportion of the number of tic words present in the text to the total number of words in the text, as a double.
   */
  public static double calculateTicDensity(int totalTics, int totalWords) {
    if (totalWords == 0) {
      return 0.0;
    }
    return (double) totalTics / totalWords;
  }
}
