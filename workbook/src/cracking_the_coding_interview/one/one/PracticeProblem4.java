package cracking_the_coding_interview.one.one;

/*  Palindrome Permutation: Given a string, write a function to check if it
is a permutation of a palindrome. A palindrome is a word or phrase that is
the same forwards and backwards. A permutation is a rearrangement of letters.
The palindrome does not need to be limited to just dictionary words.
*/

import java.util.HashMap;
import java.util.Map;

public class PracticeProblem4 {

    // Conditions for a string to have a palindrome:
    // 1. Convert all chars to lowercase, ignore non-alphabet chars
    // 2. has more than 1 char
    // 3. If Even char count: all chars appear twice
    // 4. If Odd char count: all chars but one appears twice.
    // 5. Spaces are not considered

    public static boolean isPalindromePermutation(String str){

        int strLength = str.length();
        if(strLength <= 1) return false;

        Map<Character,Integer> charFreqMap = new HashMap<>();

        for(Character c: str.toLowerCase().toCharArray()){

            // Every time new char found add to hashmap
            if(Character.isLetter(c)) {
                if (charFreqMap.containsKey(c)) {
                    // When a second instance of char found, decrease frequency to 0
                    charFreqMap.put(c, charFreqMap.getOrDefault(c, 1) - 1);
                    // If char frequency is 0, remove it from hashmap
                    if(charFreqMap.get(c) == 0) charFreqMap.remove(c);
                } else {
                    charFreqMap.put(c, 1);
                }
            }
        }

        // If hashmap contains more than 1 char, then its not a permutation of a palindrome
        if(charFreqMap.size() > 1) return false;
        return true;

        // TC: O(n), SC: O(n)

    }

    public static void main(String[] args) {

        System.out.println(isPalindromePermutation("T"));
        System.out.println(isPalindromePermutation("Tact Coa"));
        System.out.println(isPalindromePermutation("Tact Ccoa"));
        System.out.println(isPalindromePermutation("Tact 1 Coa"));
        System.out.println(isPalindromePermutation("Tact $  Coa"));
    }

    /*
    Key Takeaways:
    1. To check if a char is letter use in-build function Character.isLetter()
    2. HashMap getOrDefault()
    3. Character.getNumericValue()
     */

}
  
