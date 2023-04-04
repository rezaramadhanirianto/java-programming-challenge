package programmingChallenge.hard.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> res = new ArrayList();

        int wordLen = words[0].length();
        int size = words.length * wordLen;
        for(int i = 0; i + size <= s.length(); i++){
            String substr = s.substring(i, i + size);
            if(isValid(map, substr, wordLen)) res.add(i);
        }
        return res;
    }

    boolean isValid(Map<String, Integer> map, String substr, int wordLen){
        Map<String, Integer> count = new HashMap();
        for(int i = 0; i + wordLen <= substr.length(); i += wordLen){
            String word = substr.substring(i,i + wordLen);
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        return count.equals(map);
    }
}
