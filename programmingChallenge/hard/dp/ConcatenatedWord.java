package programmingChallenge.hard.dp;

import java.util.*;

// https://leetcode.com/problems/concatenated-words/description/
public class ConcatenatedWord {
    // O (NM)
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet();
        for(String word: words) wordSet.add(word);

        List<String> res = new ArrayList();
        // N
        for(String word: words){
            wordSet.remove(word);
            int count = helper(word, wordSet, new HashMap());
            if(count > 1) res.add(word);
            wordSet.add(word);
        }
        return res;
    }

    // M -> max(word.length)
    int helper(String word, Set<String> words, Map<String, Integer> dp){
        if(words.contains(word)) return 1;
        else if(dp.containsKey(word)) return dp.get(word);

        for(int i = 1; i < word.length(); i++){
            String first = word.substring(0, i);
            String second = word.substring(i);

            if(words.contains(first)){
                int res = helper(second, words, dp);
                if(res > 0) {
                    dp.put(word, ++res);
                    return res;
                }
            }
        }

        dp.put(word, 0);
        return 0;
    }
}
