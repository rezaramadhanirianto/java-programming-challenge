package programmingChallenge.hard.stack;

import java.util.Stack;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0, n = height.length;
        int[] left = new int[n], right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < height[i]) max = height[i];
            left[i] = max;
        }

        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (max < height[i]) max = height[i];
            right[i] = max;
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }

        return res;
    }

    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        for (int right = 0; right < height.length; right++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[right]){
                int bottom = height[stack.pop()];
                if(stack.isEmpty()) break;
                int left = height[stack.peek()];
                int water = (Math.min(height[right], left) - bottom) * (right - stack.peek() - 1);
                totalWater += water;
            }
            stack.add(right);
        }
        return totalWater;
    }
}
