package programmingChallenge.medium.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/description/
public class FindNumberWithSmallestMaxGap {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size(), res = n;
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < n; i++){
            int num = nums.get(i);
            map.computeIfAbsent(num, k -> new ArrayList()).add(i);
        }

        for(List<Integer> list: map.values()){
            list.add(list.get(0) + n);
            int max = 0;
            for(int i = 1; i < list.size(); i++){
                int diff = list.get(i) - list.get(i-1);
                max = Math.max(diff, max);
            }
            res = Math.min(max, res);
        }

        return res/2;
    }
}
