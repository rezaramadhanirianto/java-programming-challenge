package programmingChallenge.medium.stack;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/description/
// O(N * k_max)
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        int k = 0;
        StringBuilder res = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                // To handle case 2 digit number, ex: 20
                // k = 0
                // 0 * 10 + 2
                // 2 * 10 + 0
                // 20
                k = k * 10 + (c - '0');
            }else if(c == '['){
                intStack.push(k);
                stringStack.push(res);
                res = new StringBuilder();
                k = 0;
            } else if(c == ']'){
                StringBuilder temp = res;
                res = stringStack.pop();
                for (k = intStack.pop(); k > 0; k--) res.append(temp);
            } else res.append(c);
        }
        return res.toString();
    }
}
