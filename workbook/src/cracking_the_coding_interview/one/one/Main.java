package cracking_the_coding_interview.one.one;

// Problem: Is Unique
// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean isUniqueString(String word){

        // If string is null or empty or more than 128 chars (assuming string is ASCII) it's not unique
        if(word.length() > 128 || word == null || word.length() == 0) return false;

        // Iterate through each char in word, add char to HashSet.
        // If char found in HashSet, word in not unique
        // If none of the char found in HashSet, return true after for loop
        Set<Character> charSet = new HashSet<Character>();
        for(Character c: word.toCharArray()){
            if(charSet.contains(c)) return false;
            charSet.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueString("")); //Return false
        System.out.println(isUniqueString("test")); //Return false
        System.out.println(isUniqueString("tes")); //Return true
    }
}
