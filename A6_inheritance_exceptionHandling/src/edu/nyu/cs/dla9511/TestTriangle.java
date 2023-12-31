package edu.nyu.cs.dla9511;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) throws IllegalTriangleException {
        try (Scanner scanner = new Scanner(System.in)) {
            // ask user to enter 3 sides of a triangle
            System.out.println("Enter three sides of the triangle:");
            double side1 = scanner.nextDouble();
            double side2 = scanner.nextDouble();
            double side3 = scanner.nextDouble();

            // ask what color and if it is filled
            System.out.println("Enter the color of the triangle:");
            String color = scanner.next();

            System.out.println("Is the triangle filled? (true/false):");
            boolean filled = scanner.nextBoolean();

            // create triangle object with values
            Triangle triangle = new Triangle(side1, side2, side3);
            triangle.setColor(color);
            triangle.setFilled(filled);

            // display the information
            System.out.println("Triangle Information:");
            System.out.println("Area: " + triangle.getArea());
            System.out.println("Perimeter: " + triangle.getPerimeter());
            System.out.println("Color: " + triangle.getColor());
            System.out.println("Filled: " + triangle.isFilled());
        }
    }
}
