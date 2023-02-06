package programmingChallenge.medium.heap;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for(String word: words) map.put(word, map.getOrDefault(word, 0)+1);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            String key1 = a.getKey();
            int value1 = a.getValue();
            String key2 = b.getKey();
            int value2 = b.getValue();

            if(value1 != value2) return value2 - value1;
            else return key1.compareTo(key2);
        });

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.add(entry);
        }
        List<String> res = new ArrayList();
        while(!pq.isEmpty() && res.size() < k){
            String key = pq.poll().getKey();
            res.add(key);
        }
        return res;
    }
}
