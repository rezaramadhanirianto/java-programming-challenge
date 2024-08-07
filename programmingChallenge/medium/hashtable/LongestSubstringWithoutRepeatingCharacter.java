package programmingChallenge.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.get(ch) != null) {
                start = Math.max(map.get(ch) + 1, start);
            }
            map.put(ch, i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
