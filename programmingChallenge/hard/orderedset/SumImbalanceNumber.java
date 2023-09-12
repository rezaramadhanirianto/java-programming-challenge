package programmingChallenge.hard.orderedset;

import java.util.*;

// https://leetcode.com/problems/sum-of-imbalance-numbers-of-all-subarrays/description/
public class SumImbalanceNumber {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            Set<Integer> set = new HashSet();
            for (int j = i; j < n; j++) {
                int num = nums[j];
                if (set.contains(num)) {

                } else if (set.contains(num - 1) && set.contains(num + 1)) {
                    curr--;
                } else if (!set.contains(num - 1) && !set.contains(num + 1) && !set.isEmpty()) {
                    curr++;
                }
                set.add(num);
                res += curr;
            }
        }
        return res;
    }
}
