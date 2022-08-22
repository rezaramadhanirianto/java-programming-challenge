package programmingChallenge.easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
// basically we can assume all sequence number have majority element
// majority element is element that appear more than array.length / 2
public class MajorityNumber {
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums){
            Integer mapValue = map.getOrDefault(num, 0);
            if(mapValue + 1 > (nums.length/2)) return num;
            map.put(num, mapValue+1);
        }
        return 0;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
