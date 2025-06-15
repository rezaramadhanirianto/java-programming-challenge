package programmingChallenge.medium.math;

// https://leetcode.com/problems/find-the-divisibility-array-of-a-string/description/
public class FindDivisibilityArrayOfaString {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];

        long curr = 0;
        for(int i = 0; i < n; i++){
            curr = curr * 10 + (word.charAt(i) - '0');
            if(curr % m == 0) res[i] = 1;
            curr %= m;
        }
        return res;
    }
}
