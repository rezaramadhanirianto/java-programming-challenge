package programmingChallenge.hard.graph;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap();
        if (!wordList.get(0).equals(beginWord)) wordList.add(beginWord);
        for (String word : wordList) graph.put(word, new ArrayList());
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (int j = 'a'; j <= 'z'; j++) {
                    chars[i] = (char) j;
                    String curr = String.valueOf(chars);
                    if (graph.containsKey(curr)) {
                        graph.get(word).add(curr);
                    }
                }
            }
        }

        if (!graph.containsKey(endWord)) return 0;

        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.add(beginWord);
        int res = 0, sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (!visited.add(curr)) continue;
                if (curr.equals(endWord)) return sum;
                for (String word : graph.get(curr)) {
                    queue.add(word);
                }
            }
        }
        return 0;
    }

    boolean isDiff1Letter(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
