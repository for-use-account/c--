#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
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
    int scoreOfString(string s){
        int ans = 0;
        for(int i=1;i<s.length();i++) ans += abs(s[i]-s[i-1]);
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
    void reverseString(vector<char>& s) {
        int n = s.size();
        for(int i=0;i<n/2;i++) swap(s[i],s[n-i-1]);
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
    int appendCharacters(string s, string t) {
        int first = 0, longestPrefix = 0;
        while (first < s.length() && longestPrefix < t.length()) {
            if (s[first] == t[longestPrefix]) longestPrefix++;
            first++;
        }
        return t.length() - longestPrefix;
    }
};

class JuneDailyProblems: public Solution{
    public:
    JuneDailyProblems(){
        cout << "Welcome to June Daily Leetcode Problems\n";
        cout << "This is Yasaswin Palukuri, with solutions to the Daily Problems of June 2024\n";
        cout << "So, without any further ado, let's get started\n";
        solutions();
    }
    void solutions(){
        Solution s;
        do{
            cout << "Enter the day of the problem you want the answer for or 88 to Exit:\n";
            cout << "Day 1: Score of the String\n";
            cout << "Day 2: Reverse String\n";
            cout << "Day 3: Append Characters to String to Make Subsequence\n";
            cout << "88: Exit" << '\n';
            int day; cin >> day;
            switch(day){
                case 1:{
                    cout << "Enter the word \n";
                    string word; cin >> word;
                    cout << "The score of the word "<< word <<" is : " << s.scoreOfString(word) << '\n';
                    break;
                }
                case 2:{
                    cout << "Enter the word \n";
                    string word; cin >> word;
                    vector<char> le(word.begin(),word.end());
                    s.reverseString(le);
                    cout << "The reversed word is : ";
                    for(auto c:le) cout << c;
                    cout << '\n';
                    break;
                }
                case 3:{
                    cout << "Enter the two words\n";
                    string s1,s2; cin >> s1 >> s2;
                    cout << "The minimum number of characters that need to be appended to the end of " << s1 << " so that " << s2 << " becomes a subsequence of " << s1 << " is : " << s.appendCharacters(s1,s2) << '\n';
                    break;
                }
                case 88:{
                    cout << "Thank you for using the June Daily Leetcode Problems\n";
                    cout << "Hope you had a great time solving the problems\n";
                    cout << "Have a great day ahead\n";
                    return;
                }
                default:
                    cout << "Sorry, the problem for the day you entered is not available\n";
            }
        }while(true);
    }
};


int main(){
    JuneDailyProblems j;
    return 0;
}