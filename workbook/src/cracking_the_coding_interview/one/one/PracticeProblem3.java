package cracking_the_coding_interview.one.one;

/*  URLify: Write a method to replace all strings with %20. You may assume that all the string
has sufficient space at the end to hold the additional chars, and that you are given true
length of the string.
*/

import java.net.SocketException;

public class PracticeProblem3 {

    /*
    Questions:
    1. Are all spaces between two words replaced with 1 %20? Yes
    2. Are leading and trailing spaces considered? No
    */

    /*
    Logic:
    1. Step 1: Count all spaces in the string - Loop 1
    2. Step 2: From right end, when a char is encountered move to 3*(# of space) to right
               When, a space is encountered replace it with %20
     */

    public static String urlIfy(char[] str, int trueLength){

        // Note: The input string is passed as a char array because
        // Question requires to update string in-place, but Java String
        // is immutable.

        // Scan 1: Get space count
        int spaceCount = 0;
        for(int i=0; i<trueLength; i++){
            if(str[i] == ' ') spaceCount++;
        }

        // Scan 2: Shift char in str
        int charNewIndex = trueLength + spaceCount*2; // for every space, add 2 more index
        if (trueLength < str.length) str[trueLength] = '\0';
        for(int i = trueLength-1; i>=0; i--){
            // From rightmost index, if char is a space, replace with '%20'
            if(str[i] == ' ') {
                str[charNewIndex - 1] = '0';
                str[charNewIndex - 2] = '2';
                str[charNewIndex - 3] = '%';
                charNewIndex = charNewIndex - 3;
            }else{
                str[charNewIndex-1] = str[i];
                charNewIndex--;
            }
        }

        String result =  new String(str);
        return result;
    }

    public static void main(String[] args) {
        String test1 = "Mr John Smith    ";
        String test2 = " Mr John Smith      ";

        System.out.println(urlIfy(test1.toCharArray(), 13));
        System.out.println(urlIfy(test2.toCharArray(), 14));
    }


}
