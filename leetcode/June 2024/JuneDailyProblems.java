import java.util.*;

public class JuneDailyProblems extends Solution {
    static Scanner scan = new Scanner(System.in);
    public JuneDailyProblems() {
        System.out.println("Welcome to June Daily Leetcode Problems");
        System.out.println("This is Yasaswin Palukuri, with solutions to the Daily Problems of June 2024");
        System.out.println("So, without any further ado, let's get started");
        solutions();
    }

    public static void solutions() {
        Solution s = new Solution();
        while (true) {
            System.out.println("Enter the day of the problem you want the answer for or 88 to Exit:");
            System.out.println("Day 1: Score of the String");
            System.out.println("Day 2: Reverse String");
            System.out.println("Day 3: Append Characters to String to Make Subsequence");
            System.out.println("88: Exit");
            int day = scan.nextInt();
            switch (day) {
                case 1: {
                    System.out.println("Enter the word");
                    String word = scan.next();
                    System.out.println("The score of the word " + word + " is: " + s.scoreOfString(word));
                    break;
                }
                case 2:{
                    System.out.println("Enter the word");
                    String word = scan.next();
                    char[] le = word.toCharArray();
                    s.reverseString(le);
                    System.out.println("The reversed word is: " + Arrays.toString(le));
                    break;
                }
                case 3: {
                    System.out.println("Enter the first word");
                    String word1 = scan.next();
                    System.out.println("Enter the second word");
                    String word2 = scan.next();
                    System.out.println("The minimum number of characters that need to be appended to the end of " + word1 + " so that " + word2 + " becomes a subsequence of " + word1 + " is: " + s.appendCharacters(word1, word2));
                    break;
                }
                case 88: {
                    System.out.println("Thank you for using the June Daily Leetcode Problems");
                    System.out.println("Hope you had a great time solving the problems");
                    System.out.println("Have a great day ahead");
                    return;
                }
                default:
                    System.out.println("Sorry, the problem for the day you entered is not available");
            }
        }
    }

    public static void main(String[] args) {
        new JuneDailyProblems();
    }
}
class Solution {
    // Day 1: Score of a String - Q3110(Easy)
    /*
        You are given a string s. 
        The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
        Return the score of s.

        Example 1:
        Input: s = "hello"
        Output: 13
        Explanation:
        The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111.
        So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.

        Example 2:
        Input: s = "zaz"
        Output: 50
        Explanation:
        The ASCII values of the characters in s are: 'z' = 122, 'a' = 97.
        So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

        Constraints:
        2 <= s.length <= 100
        s consists only of lowercase English letters.
    */
    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return ans;
    }


    // Day 2: Reverse String - Q344(Easy)
    /*
        Write a function that reverses a string. The input string is given as an array of characters s.

        Example 1:
        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]

        Example 2:
        Input: s = ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]

        Constraints:
        1 <= s.length <= 10^5
        s[i] is a printable ascii character.
    
    */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        for(l = 0; l < r; l++, r--) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }


    // Day 3: Append Characters to String to Make Subsequence - Q2468(Medium)
    /*
        You are given two strings s and t consisting of only lowercase English letters.

        Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
        A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

        Example 1:
        Input: s = "coaching", t = "coding"
        Output: 4
        Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
        Now, t is a subsequence of s ("coachingding").
        It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
        
        Example 2:
        Input: s = "abcde", t = "a"
        Output: 0
        Explanation: t is already a subsequence of s ("abcde").
        
        Example 3:
        Input: s = "z", t = "abcde"
        Output: 5
        Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
        Now, t is a subsequence of s ("zabcde").
        It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
        

        Constraints:
        1 <= s.length, t.length <= 10^5
        s and t consist only of lowercase English letters.
    */
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return t.length() - j;
    }
}

