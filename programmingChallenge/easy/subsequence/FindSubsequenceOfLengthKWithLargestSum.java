package programmingChallenge.easy.subsequence;

import java.util.Arrays;

public class FindSubsequenceOfLengthKWithLargestSum
{
    public int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[b], nums[a]));
        Arrays.sort(indices, 0, k);
        for (int i = 0; i < k; i++) {
            res[i] = nums[indices[i]];
        }
        return res;
    }
}
