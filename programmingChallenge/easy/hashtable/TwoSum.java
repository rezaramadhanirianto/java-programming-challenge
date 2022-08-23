package programmingChallenge.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/submissions/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int first = nums[i], second = target - first;
            if(map.containsKey(second)) return new int[]{i, map.get(second)};

            map.put(first, i);
        }
        return new int[]{};
    }
}
