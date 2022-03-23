package cracking_the_coding_interview.one;

// Problem: Check Permutation
/* Given two strings, write a method to decide if one is a permutation of the other  */

import java.util.HashMap;
import java.util.Map;

/* Clarification questions:
 * 1. is comparison case-sensitive? Bob == bob? Yes
 * 2. is whitespace considered in comparison? Yes
 * */
public class PracticeProblem2 {

    public static boolean isStringPermutation(String word1, String word2){

        /* Process:
        * 1. If both strings diff length, return false
        * 2. If both strings same length:
        * 2.1 word1: Save frequency of each char in hashmap
        * 2.2 word2: For each char check hashmap
        *       - If char found: decrease frequency. If frequency < 0, return false (implies occurance of char is not same in both strings.)
        *       - If char not found: return false
        * */

        // If length of two strings are diff, they are not permutations
        if(word1.length() != word2.length()) return false;

        // Established that both strings have same length
        /* If strings are permutations, their chars will be same */
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        // Add char count in map for each char in word1
        for(Character c: word1.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,1)+1);
        }

        // Add char count in map for each char in word1
        for(Character c: word2.toCharArray()){
            if(charMap.containsKey(c)){
                charMap.put(c,charMap.get(c)-1);
                // If char's instance/frequency is less than 0 then
                // it implies that number of occurrence is not same for this char
                if(charMap.get(c) < 0) return false;
            }
            else{
                // current char not found in word1
                return false;
            }
        }
        return true;
        // TC: O(n), SC: O(1)
    }

    public static void main(String[] args) {
        System.out.println(isStringPermutation("gods","dog"));
        System.out.println(isStringPermutation("god","dog"));
        System.out.println(isStringPermutation("God","dog"));
    }

}
