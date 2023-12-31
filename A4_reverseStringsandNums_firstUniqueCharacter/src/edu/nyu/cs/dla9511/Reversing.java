package edu.nyu.cs.dla9511;

public class Reversing{
    public static void main(String[] args) {

        // You may use the variables and print commands
        // below to test that your methods work correctly.
        // Just uncomment as necessary, but please do not delete
        // or move the variables around.

        String str1 = "Hello!";
        String str2 = "stressed desserts";
        int num1 = 12345;
        int num2 = 123454321;

        System.out.println(myStringReverse(str1));
        // System.out.println(myStringReverse(str2));

        System.out.println(myIntegerReverse(num1));
        // System.out.println(myIntegerReverse(num2));

        System.out.println(checkPalindrome(str1));
        // System.out.println(checkPalindrome(str2));
        // System.out.println(checkPalindrome(num1));
        System.out.println(checkPalindrome(num1));
        
    }
    // Write the three methods for this problem below.

    // 1a) Write the Java method called myStringReverse here.
    public static String myStringReverse(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            //the new letter of the new array will be taken from the end of the intial word
            reverse += str.charAt(i);
        }
        return reverse;
    }

    // 1b) Write the Java method called myIntegerReverse here.

    public static int myIntegerReverse(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
    

    // 1c) Write the Java method called checkPalindrome here.

    public static boolean checkPalindrome(String str) {
        boolean palindrome = true;
        String reversed = myStringReverse(str); 
        for (int i = 0; i < reversed.length(); i++) {
            if(str.charAt(i) != reversed.charAt(i)) {
                palindrome = false;
            }
        }
        //by default set to true
        if (palindrome) {
            System.out.println("this string is a palindrome");
            return true;
        } else {
            System.out.println("this string is not a palindrome");
            return false;
        }
    }

    public static boolean checkPalindrome(int num) {
        int originalNum = num; // store the original number
        int reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
    
        boolean palindrome = originalNum == reversed;
    
        if (palindrome) {
            System.out.println("This integer is a palindrome");
        } else {
            System.out.println("This integer is not a palindrome");
        }
    
        return palindrome;
    }
    
}