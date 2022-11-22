package programmingChallenge.medium.dynamicprogramming;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0, maxLen = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = true;

        for(int i = n; i >= 0; i--){
            for(int j = 1; j < n - i; j++){
                int index = i + j;
                if (j == 1 && s.charAt(i) == s.charAt(index)){
                    dp[i][index] = true;
                } else if (s.charAt(i) == s.charAt(index)){
                    dp[i][index] = dp[i+1][index-1];
                }
                if (dp[i][index] && maxLen < (j+1)){
                    maxLen = j + 1;
                    start = i;
                    end = index;
                }
            }
        }

        return s.substring(start,end+1);
    }

    public String longestPalindrome2(String s) {
        int n = s.length(), start = 0, end = 0, len1, len2;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            len1 = palindromeLength(chars, i, i);
            len2 = palindromeLength(chars, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end-start){
                // ABA, i = 1, len = 3
                // 1 - (2/2) => 0
                // ABBA, i = 1, len 4
                // 1 - (3/2) => 0
                start = i - ((len-1)/2);
                // ABA, i = 1, len = 3
                // 1 + 3/2 => 2
                // ABBA, i = 1, len 4
                // 1 + (4/2) => 3
                end = i+len/2;
                System.out.println(i + " " + len + " = " + start + " " + end);
            }
        }
        return s.substring(start, end+1);
    }

    int palindromeLength(char[] chars, int left, int right){
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right-left-1;
    }
}
