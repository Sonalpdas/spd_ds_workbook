package cracking_the_coding_interview.one.one;

// Problem: Is Unique
// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

import java.util.HashSet;
import java.util.Set;

public class PracticeProblem1 {

    // Solution 1: TC: O(n), SC: O(n), n = length of string
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

    // Solution 2:
    public static boolean isUniqueBitVector(String word){

        // Solution explained: https://www.youtube.com/watch?v=0AcuCP4ikrM
        // TC: O(1), SC: O(1)
        /* This solution assumes only letters a - z. Since the checker is an
        *  integer var, it acts as a bit vector. This 32 bit integer acts as a
        *  flag for the 26 distinct chars. >> Left Bitwise Shift Operator shifts
        *  the bit by val (int equivalent of alphabet) and flag that bit on checker.*/

        int checker = 0;
        for(int i = 0; i < word.length(); i++){
            int val = word.charAt(i) - 'a';

            // << is Bitwise Left Shift operator
            /* 1 is moved by << by val times to left, marking the index corresponding
            to current char as 1. When (1<<val) is & with Checker, if it returns 1,
            it indicates that the curr alphabet has been visited before, thus returning
            false. */
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueString("")); //Return false
        System.out.println(isUniqueString("test")); //Return false
        System.out.println(isUniqueString("tes")); //Return true
        System.out.println(isUniqueBitVector("tes")); //Return true
        System.out.println(isUniqueBitVector("test")); //Return true
    }
}
