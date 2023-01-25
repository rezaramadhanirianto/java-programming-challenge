package programmingChallenge.easy.slidingwindow;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
public class SubstringsOfSizeThreeDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int[] count = new int[26];
        int n = s.length();
        int res = 0;
        for(int i = 2; i < n; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-1);
            char c3 = s.charAt(i-2);

            if(c1 == c2 || c2 == c3 || c1 == c3) continue;
            res++;
        }
        return res;
    }

    // k element
    public int countGoodSubstrings2(String s) {
        int k = 3;

        int n = s.length();
        if(n<k) return 0;

        int duplicate = 0;
        int res = 0;
        int[] freq = new int[26];

        for(int i=0; i<n; i++){
            char r = s.charAt(i);

            freq[r-'a']++;

            // just to track that theres a duplicate letter in substring
            // ex:
            // aaabbc k = 3
            // freq[a] = 3
            // freq[b] = 2
            // freq[c] = 1
            // duplicate -> 2
            if(freq[r-'a'] == 2) duplicate++;

            if(i<k-1) continue;

            // no duplicate res++
            if(duplicate==0) res++;

            int c = s.charAt(i - (k-1));

            freq[c-'a']--;
            if(freq[c-'a'] == 1) duplicate--;
        }

        return res;
    }
}
