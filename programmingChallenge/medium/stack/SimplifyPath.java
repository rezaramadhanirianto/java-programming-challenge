package programmingChallenge.medium.stack;

import java.util.*;

// https://leetcode.com/problems/simplify-path/description/
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }

    // brute force
    public String simplifyPath2(String path) {
        int n = path.length();
        Stack<String> stack = new Stack();
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < n; i++){
            char currChar = path.charAt(i);
            if(i == n-1 && currChar != '/') curr.append(currChar);
            if(currChar == '/' || i == n-1){
                if(curr.toString() != ""){
                    if(curr.toString().equals("..")){
                        if(stack.size() > 0) stack.pop();
                        else {
                            if(stack.size() > 0 && stack.peek().equals("/")) stack.pop();
                            stack.add("/");
                        }
                    }
                    else if(!curr.toString().equals(".")){
                        if(stack.size() > 0 && stack.peek().equals("/")) stack.pop();
                        stack.add(curr.toString());
                    }
                    curr.setLength(0);
                }
            }else{
                curr.append(currChar);
            }
        }
        StringBuilder res = new StringBuilder();
        while(stack.size() > 0){
            String word = stack.pop();
            if(word.equals("/")) res.insert(0, word);
            else res.insert(0, "/" + word);
        }
        if(res.toString().equals("")) res.append("/");
        return res.toString();
    }
}
