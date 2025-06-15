package programmingChallenge.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
public class SumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] times) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int time: times){
            int key = time % 60;
            int diff = (60 - key) % 60; // handle key is 0

            res += map.getOrDefault(diff, 0);
            map.put(key, map.getOrDefault(key,0) + 1);
        }
        return res;
    }

    public int numPairsDivisibleBy602(int[] times) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int time: times){
            map.put(time%60, map.getOrDefault(time%60, 0) + 1);
        }

        for(int time: times){
            int key = time % 60;
            int diff = (60 - key) % 60;
            if(map.containsKey(diff) && map.get(diff) > 0 && map.get(key) > 0){
                if(diff == key) res += (map.get(diff) - 1);
                else res += map.get(diff);
                map.put(key, map.get(key) - 1);
            }
        }
        return res;
    }
}
