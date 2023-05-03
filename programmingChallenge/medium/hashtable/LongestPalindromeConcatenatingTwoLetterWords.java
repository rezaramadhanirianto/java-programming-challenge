package programmingChallenge.medium.hashtable;

import java.util.HashMap;

// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
public class LongestPalindromeConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> m = new HashMap();
        int unpaired = 0, ans = 0;
        for (String w: words) {
            if (!m.containsKey(w)) m.put(w, 0);
            if (w.charAt(0) == w.charAt(1)) {
                if (m.get(w) > 0) {
                    unpaired--;
                    m.put(w, m.get(w) - 1);
                    ans += 4;
                }
                else {
                    m.put(w, m.get(w) + 1);
                    unpaired++;
                }
            }
            else {
                String rev = new StringBuilder(w).reverse().toString();
                if (m.containsKey(rev) && m.get(rev) > 0) {
                    ans += 4;
                    m.put(rev, m.get(rev) - 1);
                }
                else m.put(w, m.get(w) + 1);
            }

        }
        if (unpaired > 0) ans += 2;
        return ans;
    }
}
