package programmingChallenge.hard.binarysearch;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/maximum-number-of-groups-with-increasing-length/
public class MaximumNumberOfGroupsWithIncreasingLength {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        Collections.sort(usageLimits, Collections.reverseOrder());
        int max = n, min = 1, res = 1;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (isValid(mid, usageLimits)) {
                min = mid + 1;
                res = mid;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }

    boolean isValid(int curr, List<Integer> limits) {
        long[] sums = new long[limits.size()];
        for (int i = 0; i < limits.size(); i++) sums[i] = limits.get(i);

        // minus all state by mid
        // [4,3,2] mid = 3 => [1,1,1]
        // the group should be
        // 0
        // 0 1
        // 0 1 2
        int mid = curr;
        for (int i = 0; i < curr; i++) sums[i] -= mid--;

        // check if we can combine nums
        long res = 0;
        for (int i = 0; i < limits.size(); i++) {
            // if smaller than mid-- add to res
            if (sums[i] < 0) {
                res += sums[i];
                // if res < 0, that means there are groups that empty
                // if +sum[i] more than 0 that means all group not empty set res to 0
                // if not just set res += sums[i] (number of empty nums of group)
            } else if (res < 0) {
                res = Math.min(0, res + sums[i]);
            }
            // if sums[i] > 0 ignore it, that means all groups already have current number
        }
        return res >= 0;
    }
}
