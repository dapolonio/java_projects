package edu.nyu.cs.dla9511;

public class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;

    //default triange with sides 1.0
    public Triangle() throws IllegalTriangleException {
        this(1.0, 1.0, 1.0);
    }

    //construct triange with specified side values
    public Triangle(double side1, double side2, double side3) {
        try {
            if (!isValidTriangle(side1, side2, side3)) {
                throw new IllegalTriangleException("Invalid triangle sides");
            }

            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }


    public double getSide1() {
        return side1;
    }


    public double getSide2() {
        return side2;
    }


    public double getSide3() {
        return side3;
    }


    public double getArea() {
        // heron's formula to calculate the area
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }


    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    private boolean isValidTriangle(double side1, double side2, double side3) {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    // return representation of the triangle as a string
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }
}
