package edu.nyu.cs.dla9511;

public class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;


    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    //construct geometric object with color and filled value
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    //set a new filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //get date created
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    // return as string
    public String toString() {
        return "created on" + dateCreated + "\ncolor: " + color +
        " and filled: " + filled;
    }
}
