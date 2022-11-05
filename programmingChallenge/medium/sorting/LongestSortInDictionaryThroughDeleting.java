package programmingChallenge.medium.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class LongestSortInDictionaryThroughDeleting {
    public String findLongestWord(String str, List<String> dictionary) {
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList();

        for(String d: dictionary){
            if(isContain(d, chars)){
                list.add(d);
            }
        }

        Collections.sort(list);
        String output = "";
        for(String l: list) if(l.length() > output.length()) output = l;
        return output;
    }

    boolean isContain(String str, char[] chars){
        int targetSize = str.length();
        int i = 0;
        char[] strChar = str.toCharArray();
        for(char c: chars){
            if(i < targetSize && c == strChar[i]) i++;
        }

        return i == targetSize;
    }

    public String findLongestWord2(String str, List<String> dictionary) {
        char[] chars = str.toCharArray();
        String output = "";
        for(String d: dictionary)
            if((d.length() > output.length() || d.length() == output.length() && d.compareTo(output) < 0) && isContain2(d, chars))
                output = d;
        return output;
    }

    boolean isContain2(String str, char[] chars){
        int targetSize = str.length(), i = 0;
        char[] strChar = str.toCharArray();
        for(char c: chars) if(i < targetSize && c == strChar[i]) i++;
        return i == targetSize;
    }
}
