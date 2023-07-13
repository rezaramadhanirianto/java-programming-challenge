package programmingChallenge.medium.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/find-the-most-competitive-subsequence/description/
public class FindMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && deque.getLast() > nums[i] && deque.size() + n - i > k){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        int i = 0, res[] = new int[k];
        while(i < k){
            res[i++] = deque.removeFirst();
        }

        return res;
    }
}
