package programmingChallenge.medium.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0, start =0;
        Map<Character, Integer> map = new HashMap();
        // abba
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                // when goes to second a
                // map.get('a') -> 0
                // 3 - 0 + 1 -> 4 => max = 4?
                // thats why we need to check if prev value should be larger than starting point of current substring
                if(map.get(c) >= start) start = map.get(c) +1;
            }
            max = Math.max(max, i-start+1);
            map.put(c, i);
        }
        return max;
    }

    // O(NM)
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int max = 0;
        Set<Character> visited = new HashSet();
        Queue<Character> queue = new LinkedList();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!visited.add(c)){
                while(queue.peek() != c){
                    visited.remove(queue.poll());
                }
                visited.remove(queue.poll());
            }
            queue.add(c);
            visited.add(c);
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
