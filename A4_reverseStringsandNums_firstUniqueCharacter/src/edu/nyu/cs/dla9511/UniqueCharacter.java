package edu.nyu.cs.dla9511;

public class UniqueCharacter{
    public static void main(String[] args) {

        // You may use the strings below to test your firstUniqueChar method.
        
        String str1 = "How do you call a monk that subsists on vinegar?";
        String str2 = "An acetic ascetic monk!";
        String str3 = "Lily is silly";
        String str4 = "Daniel";

        System.out.println(firstUniqueChar(str4));
    }

    public static int firstUniqueChar(String str) {
        // Convert the string to lowercase to ignore capitalization
        str = str.toLowerCase();
        
        // create an array to count the occurrences of each character, assuming 26 lowcase letters a-z
        int[] count = new int[28]; 
        
        // iterate through the string and count occurrences
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // check if letter is between a or z
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }

        // find  position of the first unique character and return its position
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z' && count[c - 'a'] == 1) {
                return i;
            }
        }

        // if no unique character is found, return -1
        return -1;
    }
}