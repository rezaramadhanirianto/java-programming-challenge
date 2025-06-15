package programmingChallenge.unclassified;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Can't share question
 *
 * */
public class MoreThan1Question1 {
    public int solution1(int[] A) {
        Map<String, Integer> map = new HashMap();
        int max = 0;
        for(int a: A){
            String numStr = String.valueOf(a);
            String key = numStr.charAt(0) + " " + numStr.charAt(numStr.length() - 1);
            int prev = map.getOrDefault(key, 0);
            max = Math.max(max, prev + a);
            map.put(key, Math.max(prev, a));
        }
        return max;
    }

    public int solution2(int[] A) {
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for(int a: A){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int key: map.keySet()){
            if(key == map.get(key)){
                max = Math.max(max, key);
            }
        }
        return max;
    }

    public int solution3(int[] A) {
        int n = A.length;
        int res = 0;
        Set<Integer> set = new HashSet();
        for(int a: A) set.add(a);
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}
