package programmingChallenge.medium.monotonicstack;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/description/
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        // decreasing monotonic stack
        Stack<Integer> stack = new Stack();
        int min = Integer.MIN_VALUE;

        // find 32 pattern first
        for(int i = nums.length-1; i >= 0; i--){
            // if 2 pattern smaller than current return true
            if(nums[i] < min) return true;

            // if we found new larger value than current in stack, pop last element and set in min
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                min = stack.pop();
            }
            stack.add(nums[i]);
        }
        return false;
    }
}
