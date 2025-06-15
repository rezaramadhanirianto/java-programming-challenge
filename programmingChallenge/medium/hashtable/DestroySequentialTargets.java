package programmingChallenge.medium.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/destroy-sequential-targets/description/
public class DestroySequentialTargets {
    public int destroyTargets(int[] nums, int space) {
        int max = 0, res = 0;
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> keys = new HashMap();
        for(int num: nums) {
            int key = num % space;
            map.put(key, map.getOrDefault(key, 0) + 1);
            if(!keys.containsKey(key) || keys.get(key) > num) keys.put(key, num);
        }
        for(int key: map.keySet()){
            int diff = key % space;
            if(map.containsKey(diff)) map.put(diff, map.get(diff)+1);
        }
        for(int key: map.keySet()){
            if(map.get(key) > max || (map.get(key) == max && res > keys.get(key))){
                max = map.get(key);
                res = keys.get(key);
            }
        }
        return res;
    }

    public int destroyTargets2(int[] nums, int space) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums) map.put(num % space, map.getOrDefault(num % space, 0) + 1);
        int max = Collections.max(map.values());
        for(int num: nums){
            if(map.get(num % space) == max){
                res = Math.min(num, res);
            }
        }
        return res;
    }
}
