package programmingChallenge.medium.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;

        for(int ar: arr){
            map.put(ar, map.getOrDefault(ar - difference, 0) + 1);
        }

        for(int count: map.values()){
            res = Math.max(count, res);
        }
        return res;
    }
}
