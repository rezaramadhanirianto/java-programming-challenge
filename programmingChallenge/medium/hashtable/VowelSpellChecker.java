package programmingChallenge.medium.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/vowel-spellchecker/
public class VowelSpellChecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet(Arrays.asList(wordlist));
        HashMap<String, String> devowel = new HashMap();
        HashMap<String, String> vowel = new HashMap();
        for(String word: wordlist){
            String lower = word.toLowerCase();
            String devowelStr = lower.replaceAll("[aeiou]", "#");
            vowel.putIfAbsent(lower, word);
            devowel.putIfAbsent(devowelStr, word);
        }

        for(int i = 0; i < queries.length; i++){
            if (set.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            String devowelStr = lower.replaceAll("[aeiou]", "#");
            if(vowel.get(lower) != null){
                queries[i] = vowel.get(lower);
            }else if(devowel.get(devowelStr) != null){
                queries[i] = devowel.get(devowelStr);
            }else{
                queries[i] = "";
            }
        }
        return queries;
    }
}
