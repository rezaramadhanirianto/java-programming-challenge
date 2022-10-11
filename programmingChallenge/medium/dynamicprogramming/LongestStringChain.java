package programmingChallenge.medium.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> a.length()-b.length());
        Map<String, Integer> map = new HashMap();
        int max = 0;
        for(String word: words){
            map.put(word, 1);
            for(int i = 0; i < word.length(); i++){
                StringBuilder strBuilder = new StringBuilder(word);
                String parentWord = strBuilder.deleteCharAt(i).toString();
                if(map.containsKey(parentWord) && map.get(word) < map.get(parentWord)+1){
                    map.put(word, map.get(parentWord)+1);
                }
            }
            max = Math.max(map.get(word), max);
        }
        return max;
    }
}
