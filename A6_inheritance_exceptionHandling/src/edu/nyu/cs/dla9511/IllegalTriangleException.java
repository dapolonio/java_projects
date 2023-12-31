package edu.nyu.cs.dla9511;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }

    public IllegalTriangleException(String message, Throwable cause) {
        super(message, cause);
    }
}
