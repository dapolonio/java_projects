package edu.nyu.cs.dla9511;

import java.util.Random;
import java.util.Scanner;
public class Ex2a{

    public static void main(String[] args) {
        //  create array with 100 randomly chosen integers
        int[] randomArray = generateRandomArray(100);

      
        int index = getIndexFromUser();

        try {
            // display the corresponding element value
            int element = getElementAtIndex(randomArray, index);
            System.out.println("Element at index " + index + ": " + element);
        } catch (ArrayIndexOutOfBoundsException e) {
            // handle the exception if user index is out of bounds
            System.out.println("Out of Bounds");
        }
    }

    // method to generate an array with 100 randomly chosen integers
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    // method to prompt the user to enter the index of an array
    private static int getIndexFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the array: ");

        // validate user input to ensure it's an integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer index.");
            scanner.next(); 
            System.out.print("Enter the index of the array: ");
        }

        return scanner.nextInt();
    }

    // method to get the element at the specified index
    private static int getElementAtIndex(int[] array, int index) {
        return array[index];
    }
}
