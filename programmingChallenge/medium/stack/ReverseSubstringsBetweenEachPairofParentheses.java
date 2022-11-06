package programmingChallenge.medium.stack;

import java.util.Stack;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
public class ReverseSubstringsBetweenEachPairofParentheses {
    // bruteforce
    // (N^2) cuz reverse function is N
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack();

        char[] chars = s.toCharArray();
        String str = "";
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != '(' && chars[i] != ')'){
                str += chars[i];
            }else if(chars[i] == '('){
                stack.push(str);
                str = "";
            }else{

                // if we find ")"
                // let's reverse our str
                // and append it to before string in stack
                String last = stack.pop();
                str = new StringBuilder(str).reverse().toString();
                str = last + str;
            }
        }
        return str;
    }

    // wormholes solution
    //      3    2          1
    // ( <- <- ( -> -> ) <- <- )
    // https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/383670/JavaC%2B%2BPython-Tenet-O(N)-Solution
    public String reverseParentheses2(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(')
                opened.push(i);
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                System.out.println(s.charAt(i) + " " + pair[i] + " " + s.charAt(pair[i]));
                i = pair[i];
                d = -d;
            } else {
                System.out.println(s.charAt(i) + " " + i);

                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
