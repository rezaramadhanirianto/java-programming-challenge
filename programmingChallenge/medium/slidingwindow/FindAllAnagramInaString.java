package programmingChallenge.medium.slidingwindow;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagramInaString {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), size = p.length();
        int[] count = new int[26];
        List<Integer> res = new ArrayList();
        if(size > n) return res;

        for(char c: p.toCharArray()) count[c-'a']++;

        int left = size;
        int j = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            while(j < s.length() && j - i < size){
                if(count[s.charAt(j++)-'a']-- > 0) left--;
            }
            if(left == 0) res.add(i);
            if(count[c-'a']++ >= 0) left++;
            // same as above
            // if(count[c-'a'] >= 0) left++;
            // count[c-'a']++
        }
        return res;
    }
}
