package cracking_the_coding_interview.one;

/*
One Away: There are three types of edits that can be performed on strings:
insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit
(or zero edits) away.

EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false
 */

public class PracticeProblem5 {

    // Logic:
    // Use a pointer for each string and compare values at each index
    // If more than 2 delta found, then return false
    // At the end of one of the pointers, if delta <= 1, return true

    public static boolean isOneEditAway(String str1, String str2){

        int lengthDiff = Math.abs(str1.length() - str2.length());
        int editCount = 0;
        // Case 1: If Strings have different length
        if(lengthDiff > 1) return false;

        if(lengthDiff == 1) {
            int idx1 = 0, idx2 = 0;
            while(idx1 < str1.length() && idx2 < str2.length()){
                if(str1.charAt(idx1) != str2.charAt(idx2)){
                    if((idx1 != idx2) && editCount > 1) return false;
                    idx2++; // Question assumes str1 will always be >= str2 length
                    editCount++;
                }else{
                    idx1++; idx2++;
                }
            }
        }else if(lengthDiff == 0){
            // Case 2: If Strings have same length
            //Compare String chars, if more tha 2 difference then return false
            for(int i = 0; i<str1.length(); i++){
                if(str1.charAt(i) != str2.charAt(i)) editCount++;
                if(editCount > 1) return false;
            }
        }

        return true;
    }

    public static boolean isOneEditAwayOptimized(String str1, String str2){

        // Case 1: When length diff > 2, return false
        int lengthDiff = Math.abs(str1.length()-str2.length());
        if(lengthDiff > 2) return false;

        // Case 2: If lengthDiff < 2
        // Find short and long string
        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str2 : str1;

        // Compare string chars
        int idx1 = 0, idx2 = 0;
        boolean isCharDfferent = false;
        while(idx1 < s1.length() && idx2 < s2.length()){

            if(s1.charAt(idx1) != s2.charAt(idx2)){

                if(isCharDfferent) return false;
                isCharDfferent = true;

                if(s1.length() == s2.length()){
                    // In case string lengths are same its replace type edit
                    // Increase short string index
                    idx1++;
                }

            }else{
                // When both chars same
                idx1++;
            }

            idx2++; // Always move index for longer string
        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));

        System.out.println(isOneEditAwayOptimized("pale", "ple"));
        System.out.println(isOneEditAwayOptimized("pales", "pale"));
        System.out.println(isOneEditAwayOptimized("pale", "bale"));
        System.out.println(isOneEditAwayOptimized("pale", "bake"));

    }

    /*
    Key Takeaways:
    1. Pointers help with String comparisons
    2. In these kinds of problems, identifying activities and their logic
    before writing code helps optimize solution and sheds clarity on the
    required logic and edge cases.
     */

}
