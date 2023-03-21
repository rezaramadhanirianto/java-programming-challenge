package programmingChallenge.medium.hastable;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationByPhoneNumber {
    private String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList();
        helper(new StringBuilder(), digits, 0, res);
        return res;
    }

    void helper(StringBuilder sb, String digits, int id, List<String> res){
        if(id == digits.length()){
            if(!sb.isEmpty()) res.add(sb.toString());
            return;
        }

        String letters = KEYS[digits.charAt(id) - '0'];
        for(int i = 0; i < letters.length(); i++){
            sb.append(letters.charAt(i));
            helper(sb, digits, id + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
