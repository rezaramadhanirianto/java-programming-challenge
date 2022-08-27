package programmingChallenge.medium.hastable;

import java.util.List;

// https://leetcode.com/problems/replace-words/submissions/
// categories[hashtable, string, trie]
public class ReplaceWord {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sentences = sentence.split(" ");
        String output = "";
        for(String s: sentences){
            String change = "";
            for(String d: dictionary){
                if(d.length() <= s.length() && d.equals(s.substring(0, d.length())) && (change.isBlank() || change.length() > d.length())){
                    change = d;
                }
            }
            if(change.isBlank()) output += s + " ";
            else output += change + " ";
        }
        return output.trim();
    }

    public String replaceWordsTrie(List<String> dictionary, String sentence){
        Node trie = new Node();
        for(String d: dictionary){
            Node trav = trie;
            for(char c: d.toCharArray()){
                if(trav.nodes[c - 'a'] == null) trav.nodes[c - 'a'] = new Node();
                trav = trav.nodes[c - 'a'];
            }
            trav.word = d;
        }

        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            Node trav = trie;
            for(char c: words[i].toCharArray()){
                trav = trav.nodes[c - 'a'];
                if(trav == null) break;
                else if(trav.word != null){
                    words[i] = trav.word;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }

    class Node {
        Node[] nodes = new Node[26];
        String word;
    }
}
