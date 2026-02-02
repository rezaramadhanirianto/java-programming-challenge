package programmingChallenge.medium.hashtable;

import java.util.*;

public class NumberOfSubsequencesThatSatisfyTheGivenSum {
    public List<String> partitionString(String s) {
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));
            while (seen.contains(currentChar) && i < s.length() - 1) {
                currentChar += s.charAt(++i);
            }
            result.add(currentChar);
            seen.add(currentChar);
        }
        return result;
    }
}
