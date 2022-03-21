package cracking_the_coding_interview.one;

/*
String Compression:
------------------
Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than
the original string, your method should return the original string. You can assume the string has only uppercase and
lowercase letters (a - z).
*/

/*
Clarifications:
--------------
1. In the final string every char is followed by its frequency of continuous occurrence
2. String has only alphabets
3. Case sensitivity is considered
4. If a char appears somewhere else in the string, i.e., after a gap, the next occurrence is treated with new frequency.
5. If final string length >= original string length, return original string
6. In Java this cannot be done in-place, hence a StringBuilder can be used to construct compressed string
 */

import java.util.HashMap;
import java.util.Map;

public class PracticeProblem6 {

    //Brute Force method - using two pointers
    public static String compressString(String uncompressedString){

        StringBuilder compressedString = new StringBuilder();

        // Using two pointers to find the continuous window of length for each char
        int left_idx = 0, right_idx = 0;
        char currChar = uncompressedString.charAt(0);
        int currCharFreq = 0;

        while(right_idx < uncompressedString.length()){

            if(uncompressedString.charAt(left_idx) == uncompressedString.charAt(right_idx)){
                // if char at left and right index are same, increase freq, move right by one;
                currCharFreq++;
                right_idx++;

                if(right_idx == uncompressedString.length() - 1){
                    compressedString.append(currChar);
                    compressedString.append(currCharFreq+1);
                }
            }else{
                // Else add this char to compressedString with freq, and then move left to position of right
                compressedString.append(currChar);
                compressedString.append(currCharFreq);
                left_idx = right_idx; // Move left index to next char
                currCharFreq = 0; // Reset frequency var to 0
                currChar = uncompressedString.charAt(left_idx);
            }

        }

        return compressedString.length() >= uncompressedString.length() ? uncompressedString : compressedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abcdefg"));
        System.out.println(compressString("bbZZcDDaaaN"));
        System.out.println(compressString("bbZZcDDaaaaaN"));

    }
}
