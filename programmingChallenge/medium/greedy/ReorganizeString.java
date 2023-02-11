package programmingChallenge.medium.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap();
        int n = s.length();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
            // because the char with highest count can be in the first and last index
            // S.length() + 1 count in the additional index after the last char in S
            // consider S = "aaabb" S.length() = 5 -> "ababa " ok S.length() + 1 = 6 -> 3 'a' is the maximum you could have. if you have 4 'a', it's not possible
            if(map.get(c) > ((s.length() + 1) / 2)) return "";
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) pq.add(new int[] {c, map.get(c)});

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)){
                sb.append((char) first[0]);
                if(--first[1] > 0) pq.add(first);
            }else{
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if(--second[1] > 0) pq.add(second);
                pq.add(first);
            }
        }
        return sb.toString();
    }
}
